package masterball.compiler.middleend.optim;

import masterball.compiler.middleend.analyzer.CFGBuilder;
import masterball.compiler.middleend.analyzer.CallGraphAnalyzer;
import masterball.compiler.middleend.llvmir.User;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;
import masterball.compiler.middleend.llvmir.inst.*;
import masterball.compiler.share.lang.LLVM;
import masterball.compiler.share.lang.MxStar;
import masterball.compiler.share.pass.IRModulePass;
import masterball.debug.Log;

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

    private static final int CalleeInstNumThreshold = 600,
                             ForcedCalleeInstNumThreshold = 200,
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
        return !isNecessary(callee) &&
               // this is for correct order of inlining, do not use cyclic
               callee.node.call.isEmpty() &&
               instNum.get(caller) <= CallerInstNumThreshold &&
               instNum.get(callee) <= CalleeInstNumThreshold;
    }

    private boolean canForceInline(IRFunction caller, IRFunction callee) {
        return  !isNecessary(callee) &&
                instNum.get(caller) <= CallerInstNumThreshold &&
                instNum.get(callee) <= ForcedCalleeInstNumThreshold;
    }

    private void collectAbleSet() {
        inlineAbleSet.clear();
        instNum.clear();

        for (IRFunction function : module.functions) {
            instNum.putIfAbsent(function, 0);
            for (IRBlock block : function.blocks) {
                instNum.put(function, instNum.get(function) + block.instructions.size());
                // Log.info("inst num", function.name, instNum.get(function));
            }
        }

        for (IRFunction function : module.functions) {
            for (IRCallInst call : function.node.call)
                if ((!forced && canInline(function, call.callFunc()))
                        || (forced && canForceInline(function, call.callFunc())))
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

        // step 1. replicate the function body

        // backup the block to avoid concurrent exception in self-recursion
        ArrayList<IRBlock> calleeBlocks = new ArrayList<>(callee.blocks);

        for (IRBlock block : calleeBlocks) {
            IRBlock inlinedBlock = new IRBlock(block.name + LLVM.InlineSuffix, caller);

            // Log.info("inline", block.identifier(), inlinedBlock.identifier());

            replaceValueMap.put(block, inlinedBlock);
            replaceBlockMap.put(block, inlinedBlock);

            // phi first, because the block will be terminated after normal inst inserted
            for (IRPhiInst phi : block.phiInsts) {
                IRPhiInst newPhi = (IRPhiInst) phi.copy();
                newPhi.setParentBlock(inlinedBlock);
                replaceValueMap.put(phi, newPhi);
            }

            for (IRBaseInst inst : block.instructions) {
                IRBaseInst newInst = inst.copy();
                newInst.setParentBlock(inlinedBlock);
                replaceValueMap.put(inst, newInst);
            }
        }

        for (int i = 0; i < callee.getArgNum(); i++)
            replaceValueMap.put(callee.getArg(i), call.getArg(i));

        for (IRBlock oldBlock : replaceBlockMap.keySet()) {
            IRBlock newBlock = replaceBlockMap.get(oldBlock);

            // Log.info("mapping", oldBlock.identifier(), newBlock.identifier());

            for (IRBaseInst inst : newBlock.instructions)
                replaceOperand(inst, replaceValueMap);

            for (IRPhiInst phi : newBlock.phiInsts)
                replaceOperand(phi, replaceValueMap);
        }

        //step 2. relink the block

        IRBlock inlineExit = new IRBlock(LLVM.SplitBlockLabel, caller);

        // split the parentBlock of call
        boolean splitStart = false;
        var it = inlineEntry.instructions.iterator();

        while (it.hasNext()) {
            IRBaseInst inst = it.next();
            if (inst == call) splitStart = true;
            if (!splitStart) continue;
            if (inst != call) inst.setParentBlock(inlineExit);
            it.remove();
        }

        // call parentBlock to inline.entry
        inlineEntry.tAddLast(new IRBrInst(replaceBlockMap.get(callee.entryBlock), null));

        // split to inlineEntry and inlineExit, redirect the suc to inlineExit
        inlineEntry.nexts.forEach(suc -> suc.redirectPreBlock(inlineEntry, inlineExit));

        // ret -> replaceAllUses
        IRRetInst ret = (IRRetInst) replaceBlockMap.get(callee.exitBlock).terminator();
        if (!callee.isVoid()) {
            call.replaceAllUsesWith(ret.retVal());
        }

        // ret - > jump to split
        replaceBlockMap.get(callee.exitBlock).terminator().removedFromAllUsers();
        replaceBlockMap.get(callee.exitBlock).tReplaceTerminator(
                new IRBrInst(inlineExit, null)
        );

        if (caller.exitBlock == inlineEntry) caller.exitBlock = inlineExit;

        new CFGBuilder().runOnFunc(caller);
    }

    @Override
    public void runOnModule(IRModule module) {
        this.module = module;

        Log.track("start inlining");

        while (true) {
            new CallGraphAnalyzer().runOnModule(module);
            collectAbleSet();

            // Log.mark("able set: ");
            // inlineAbleSet.forEach(call -> Log.info(call.callFunc().identifier()));

            if (inlineAbleSet.isEmpty()) break;

            Log.info("call size", inlineAbleSet.size());

            for (IRCallInst pendingCall : inlineAbleSet) {
                inlining(pendingCall);
            }
        }

        new CallGraphAnalyzer().runOnModule(module);

        // remove dead function
        module.functions.removeIf(function -> !isNecessary(function) && function.node.caller.size() == 0);
    }
}
