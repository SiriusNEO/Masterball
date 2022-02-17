package masterball.compiler.middleend.optim;

import masterball.compiler.middleend.analyzer.LoopAnalyzer;
import masterball.compiler.middleend.llvmir.IRTranslator;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.constant.IntConst;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.hierarchy.Loop;
import masterball.compiler.middleend.llvmir.inst.IRBaseInst;
import masterball.compiler.middleend.llvmir.inst.IRBinaryInst;
import masterball.compiler.middleend.llvmir.inst.IRPhiInst;
import masterball.compiler.share.lang.LLVM;
import masterball.compiler.share.pass.IRFuncPass;
import masterball.compiler.share.pass.IRLoopPass;
import masterball.debug.Log;

import java.util.HashMap;
import java.util.Objects;

/**
 * Induction Variable Related Transform
 *
 * this pass provides some optimizations on induction variable in loop
 * very simple, no derived propagation
 * 1. collect induction variable
 * 2. some strength reduction (only mul)
 *
 * @reference: Tiger Book chapter 18.3
 *
 * @requirement: LoopAnalyzer.
 */

public class IVTrans implements IRFuncPass, IRLoopPass {
    private HashMap<Value, BIV> basicIV = new HashMap<>();
    private HashMap<Value, IV> derivedIV = new HashMap<>();

    private static class IV {
        Value basic, invariant;
        String op;

        // self = invariant * basic / basic + invariant
        private IV(Value basic, Value invariant, String op) {
            this.basic = basic;
            this.invariant = invariant;
            this.op = op;
        }
    }

    public static class BIV extends IV {
        Value init;
        IRBlock initBLock;
        IRBaseInst incr;

        private BIV(Value basic, Value invariant, String op, Value init, IRBlock initBLock, IRBaseInst incr) {
            super(basic, invariant, op);
            this.init = init;
            this.initBLock = initBLock;
            this.incr = incr;
        }
    }

    @Override
    public void runOnLoop(Loop loop) {
        Log.mark("run loop");
        loop.blocks.forEach(block -> Log.info(block.identifier()));

        collectBasicIndVar(loop);
        Log.mark("collect basic finish");
        basicIV.keySet().forEach(value -> Log.info(value.identifier(), basicIV.get(value).invariant.identifier(), basicIV.get(value).op));
        collectDerivedIndVar(loop);
        Log.mark("collect derived finish");
        derivedIV.keySet().forEach(value -> Log.info(value.identifier(), derivedIV.get(value).invariant.identifier(), derivedIV.get(value).op));
        strengthReduction(loop);
        loop.nestedLoops.forEach(this::runOnLoop);
    }

    /**
     * basic induction variable: i=i+c or i=i-c
     * in LLVM IR, this variable must be a Phi like:
     * phi = phi [init, init_block] [add/sub, body_block]
     */
    private void collectBasicIndVar(Loop loop) {
        basicIV.clear();
        for (IRPhiInst phi : loop.head.phiInsts) {
            if (phi.operandSize() != 4) continue;
            int bodyIndex = (loop.blocks.contains(phi.getOperand(1))) ? 1 : 3;
            int initIndex = 4 - bodyIndex;

            IRBlock initBLock = (IRBlock) phi.getOperand(initIndex);

            if (!loop.blocks.contains(initBLock)) {
                var incrVal = phi.getOperand(bodyIndex-1);
                var initVal = phi.getOperand(initIndex - 1);
                if (incrVal instanceof IRBinaryInst) {
                    IRBinaryInst biInst = (IRBinaryInst) incrVal;
                    Value addVal = null;

                    if (Objects.equals(biInst.op, LLVM.AddInst) || Objects.equals(biInst.op, LLVM.SubInst)) {
                        if (loop.isInvariant(biInst.lhs()) && (biInst.rhs().equals(phi)))
                            addVal = biInst.lhs();
                        else if (loop.isInvariant(biInst.rhs()) && (biInst.lhs()).equals(phi))
                            addVal = biInst.rhs();
                    }

                    if (addVal != null)
                        basicIV.put(phi, new BIV(phi, addVal, biInst.op, initVal, initBLock, biInst));
                }
            }
        }
    }

    /*
     * Notice: only one-level derived induction variable
     * if x = a*i + b, y = c*x+d = c*(a*i+b)+d=cai+cb+d,
     * this is hard to describe in LLVM IR if a, b, c, d are not all constant.
     */
    private void collectDerivedIndVar(Loop loop) {
        derivedIV.clear();

        for (IRBlock block : loop.blocks)
            for (IRBaseInst inst : block.instructions) {
                if (inst instanceof IRBinaryInst) {

                    IRBinaryInst biInst = (IRBinaryInst) inst;

                    Value basic = null;
                    Value mulVal = null;

                    if (Objects.equals(biInst.op, LLVM.MulInst)) {
                        if (basicIV.containsKey(biInst.lhs()) && loop.isInvariant(biInst.rhs())) {
                            basic = biInst.lhs();
                            mulVal = biInst.rhs();
                        }
                        else if (basicIV.containsKey(biInst.rhs()) && loop.isInvariant(biInst.lhs())) {
                            basic = biInst.rhs();
                            mulVal = biInst.lhs();
                        }
                    }

                    if (mulVal != null)
                        derivedIV.put(biInst, new IV(basic, mulVal, biInst.op));
                }
            }
    }

    /*
     * for each j = c * i, trans it to an add IV
     * 1. insert j init: j = c * init after i init
     * 2. insert j upd:  j = j + c * step after i incr
     */
    private void strengthReduction(Loop loop) {
        for (var entry : derivedIV.entrySet()) {
            IRBaseInst key = (IRBaseInst) entry.getKey();
            var iv = entry.getValue();
            var biv = basicIV.get(iv.basic);
            Value newInit;
            boolean neg = Objects.equals(biv.op, LLVM.SubInst);

            Value newStep = null;

            if (biv.invariant instanceof IntConst && ((IntConst) biv.invariant).constData == 1)
                newStep = iv.invariant;
            else {
                newStep = new IRBinaryInst(LLVM.MulInst, IRTranslator.i32Type, iv.invariant, biv.invariant, null);
                biv.initBLock.tAddBeforeTerminator((IRBaseInst) newStep);
            }

            if (iv.invariant instanceof IntConst && biv.init instanceof IntConst) {
                newInit = new IntConst(((IntConst) iv.invariant).constData * ((IntConst) biv.init).constData);
            }
            else {
                newInit = new IRBinaryInst(LLVM.MulInst, IRTranslator.i32Type, biv.init, iv.invariant, null);
                biv.initBLock.tAddBeforeTerminator((IRBaseInst) newInit);
            }

            var it = biv.incr.parentBlock.instructions.listIterator(
                    biv.incr.parentBlock.instructions.indexOf(biv.incr)
            );

            var newPhi = new IRPhiInst(IRTranslator.i32Type, null, newInit, biv.initBLock);
            var newIncr = new IRBinaryInst(neg ? LLVM.SubInst : LLVM.AddInst, IRTranslator.i32Type, newPhi, newStep, null);

            biv.incr.parentBlock.tAddByIterator(newIncr, it);
            newPhi.addBranch(newIncr, newIncr.parentBlock);
            loop.head.tAddPhi(newPhi);

            key.replaceAllUsesWith(newPhi);
            key.parentBlock.instructions.remove(key);
        }
    }

    @Override
    public void runOnFunc(IRFunction function) {
        Log.track("IV Trans", function.identifier());

        new LoopAnalyzer().runOnFunc(function);
        function.topLevelLoops.forEach(this::runOnLoop);
    }
}
