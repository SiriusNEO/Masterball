package masterball.compiler.middleend.analyzer;

import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.inst.IRBrInst;
import masterball.compiler.share.pass.IRFuncPass;

public class CFGBuilder implements IRFuncPass {

    @Override
    public void runOnFunc(IRFunction function) {
        for (IRBlock block : function.blocks) {
            block.prevs.clear();
            block.nexts.clear();
        };

        for (IRBlock block : function.blocks) {
            var terminator = block.terminator();
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
}
