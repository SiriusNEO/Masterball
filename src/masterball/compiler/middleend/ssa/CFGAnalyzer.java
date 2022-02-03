package masterball.compiler.middleend.ssa;

import masterball.compiler.backend.rvasm.operand.Register;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.inst.IRBrInst;
import masterball.compiler.share.pass.IRFuncPass;

import java.util.HashSet;

public class CFGAnalyzer implements IRFuncPass {

    private void buildCFG(IRFunction function) {
        for (IRBlock block : function.blocks) {
            var terminator = block.instructions.getLast();
            if (terminator instanceof IRBrInst) {
                if (((IRBrInst) terminator).isJump()) {
                    block.linkBlock(((IRBrInst) terminator).destBlock());
                } else {
                    block.linkBlock(((IRBrInst) terminator).ifTrueBlock());
                    block.linkBlock(((IRBrInst) terminator).ifFalseBlock());
                }
            }
        }
    }

    private void removeUnreachableBlock(IRFunction function) {
        HashSet<IRBlock> removeSet = new HashSet<>();

        boolean removed = true;
        while (removed) {
            removed = false;
            for (IRBlock block : function.blocks) {
                if (block == function.entryBlock()) continue;
                if (removeSet.contains(block)) continue;
                if (block.prevs.isEmpty()) {
                    removeSet.add(block);
                    for (IRBlock suc : block.nexts) {
                        suc.prevs.remove(block);
                    }
                    removed = true;
                }
            }
        }

        removeSet.forEach(function.blocks::remove);
    }

    @Override
    public void runOnFunc(IRFunction function) {
        buildCFG(function);
        removeUnreachableBlock(function);
    }
}
