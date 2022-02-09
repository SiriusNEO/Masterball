package masterball.compiler.middleend.optim;

import masterball.compiler.middleend.analyzer.CallGraphAnalyzer;
import masterball.compiler.middleend.llvmir.User;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;
import masterball.compiler.middleend.llvmir.inst.IRBaseInst;
import masterball.compiler.middleend.llvmir.inst.IRBrInst;
import masterball.compiler.middleend.llvmir.inst.IRCallInst;
import masterball.compiler.middleend.llvmir.inst.IRPhiInst;
import masterball.compiler.share.lang.LLVM;
import masterball.compiler.share.lang.MxStar;
import masterball.compiler.share.pass.IRModulePass;

import java.util.*;

/**
 * Function Inliner Pass
 *
 * run CFG Simplifier after this pass to get better performance
 *
 * @requirement: CallGraphAnalyzer
 *
 */

public class FuncInliner implements IRModulePass {

    private IRModule module;
    private final boolean forced;

    private static final int CalleeInstNumThreshold = 400,
                             CallerInstNumThreshold = 1000;

    private final Set<IRCallInst> inlineAbleSet = new HashSet<>();
    private final Map<IRFunction, Integer> instNum = new HashMap<>();

    public FuncInliner(boolean forced) {
        this.forced = forced;
    }

    private boolean isNecessary(IRFunction function) {
        return function.name.equals(MxStar.mainKw) || module.builtinFunctions.contains(function);
    }

    private boolean canInline(IRFunction caller, IRFunction callee) {
        return isNecessary(callee) &&
               !callee.node.cyclic &&
               instNum.get(caller) <= CallerInstNumThreshold &&
               instNum.get(callee) <= CalleeInstNumThreshold;
    }

    private boolean canForceInline(IRFunction caller, IRFunction callee) {
        return  instNum.get(caller) <= CallerInstNumThreshold &&
                instNum.get(callee) <= CalleeInstNumThreshold;
    }

    private void collectAbleSet() {
        inlineAbleSet.clear();
        instNum.clear();

        for (IRFunction function : module.functions) {
            instNum.putIfAbsent(function, 0);
            for (IRBlock block : function.blocks)
               instNum.put(function, instNum.get(function) + block.instructions.size());
        }

        for (IRFunction function : module.functions) {
            for (IRCallInst call : function.node.call)
                if (canInline(function, call.callFunc()))
                    inlineAbleSet.add(call);
        }
    }

    private void replaceOperand(User user, Map<Value, Value> replaceMap) {
        for (int i = 0; i< user.operands.size(); i++) {
            if (replaceMap.containsKey(user.getOperand(i)))
                user.resetOperand(i, replaceMap.get(user.getOperand(i)));
        }
    }

    // callee's code will be inserted to caller
    private void inlining(IRCallInst call) {
        IRFunction caller = call.parentBlock.parentFunction,
                   callee = call.callFunc();

        Map<Value, Value> replaceValueMap = new HashMap<>();
        Map<IRBlock, IRBlock> replaceBlockMap = new HashMap<>();

        IRBlock inlineEntry = call.parentBlock;
        IRBlock inlineExit = new IRBlock(LLVM.SplitPrefix + call.parentBlock.name, caller);

        // step 1. replicate the function body
        for (IRBlock block : callee.blocks) {
            IRBlock inlinedBlock = new IRBlock(LLVM.InlinePrefix + block.name, caller);
            replaceValueMap.put(block, inlinedBlock);
            replaceBlockMap.put(block, inlinedBlock);
            for (IRBaseInst inst : block.instructions) {
                IRBaseInst newInst = inst.copy();
                newInst.setParentBlock(inlinedBlock);
            }
            for (IRPhiInst phi : block.phiInsts) {
                IRPhiInst newPhi = (IRPhiInst) phi.copy();
                newPhi.setParentBlock(block);
            }
        }

        for (int i = 0; i < callee.getArgNum(); i++)
            replaceValueMap.put(callee.getArg(i), call.getArg(i));

        for (IRBlock oldBlock : replaceBlockMap.keySet()) {
            IRBlock newBlock = replaceBlockMap.get(oldBlock);

            for (IRBaseInst inst : newBlock.instructions)
                replaceOperand(inst, replaceValueMap);

            for (IRPhiInst phi : newBlock.phiInsts)
                replaceOperand(phi, replaceValueMap);
        }

        //step 2. relink the block
        boolean splitStart = false;
        var it = inlineEntry.instructions.iterator();

        while (it.hasNext()) {
            IRBaseInst inst = it.next();
            if (inst == call) splitStart = true;
            if (!splitStart) continue;
            if (inst != call) inst.setParentBlock(inlineExit);
            it.remove();
        }

        inlineEntry.tAddLast(new IRBrInst(replaceBlockMap.get(callee.entryBlock), null));
        replaceBlockMap.get(callee.exitBlock).tReplaceTerminator(
                new IRBrInst(inlineExit, null)
        );
    }

    @Override
    public void runOnModule(IRModule module) {
        this.module = module;

        while (true) {
            new CallGraphAnalyzer().runOnModule(module);
            collectAbleSet();
            if (inlineAbleSet.isEmpty()) break;
            for (IRCallInst pendingCall : inlineAbleSet) {
                inlining(pendingCall);
            }
        }

        // remove dead function
        module.functions.removeIf(function -> function.node.caller.size() == 0);
    }
}
