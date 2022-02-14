package masterball.compiler.middleend.optim;

import masterball.compiler.middleend.analyzer.CFGBuilder;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.inst.IRBaseInst;
import masterball.compiler.middleend.llvmir.inst.IRBrInst;
import masterball.compiler.share.pass.IRFuncPass;
import masterball.debug.Log;

import java.util.HashSet;

public class CFGSimplifier implements IRFuncPass {
    private void removeUnreachableBlock(IRFunction function) {
        HashSet<IRBlock> toRemoveSet = new HashSet<>();

        boolean removed = true;
        while (removed) {
            removed = false;
            for (IRBlock block : function.blocks) {
                if (block == function.entryBlock) continue;
                if (toRemoveSet.contains(block)) continue;
                if (block.prevs.isEmpty()) {
                    toRemoveSet.add(block);
                    for (IRBlock suc : block.nexts) {
                        suc.prevs.remove(block);
                    }
                    removed = true;
                }
            }
        }

        toRemoveSet.forEach(function.blocks::remove);
    }

    private void mergeBlocks(IRFunction function) {
        HashSet<IRBlock> toMergeSet = new HashSet<>(); // merge with pre

        function.blocks.forEach(block -> {
            if (block.prevs.size() == 1 && block.prevs.get(0).nexts.size() == 1) {
                assert block.prevs.get(0).nexts.get(0) == block;
                toMergeSet.add(block);
            }
        });

        for (IRBlock beMerged : toMergeSet) {
            IRBlock preBlock = beMerged.prevs.get(0);

            // Log.info("merged", preBlock.identifier(), beMerged.identifier());
            // beMerged.nexts.forEach(suc -> Log.info(suc.identifier()));

            var preTerminator = preBlock.terminator();

            // 1 nexts, must be Jmp
            assert preTerminator instanceof IRBrInst && ((IRBrInst) preTerminator).isJump();

            preBlock.nexts.remove(beMerged);
            preBlock.instructions.remove(preTerminator);
            preBlock.isTerminated = false;

            preBlock.nexts.addAll(beMerged.nexts);
            for (IRBlock suc : beMerged.nexts) {
                suc.redirectPreBlock(beMerged, preBlock);
            }

            // terminate it also
            for (IRBaseInst inst : beMerged.instructions) inst.setParentBlock(preBlock);

            for (IRBaseInst phi : beMerged.phiInsts) phi.setParentBlock(preBlock);

            if (function.exitBlock == beMerged) function.exitBlock = preBlock;
        }

        function.blocks.removeAll(toMergeSet);
    }

    @Override
    public void runOnFunc(IRFunction function) {
        Log.track("CFG Simplifier", function.identifier());
        new CFGBuilder().runOnFunc(function);
        removeUnreachableBlock(function);
        mergeBlocks(function);
    }
}
