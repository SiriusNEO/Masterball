package masterball.compiler.middleend.optim;

import masterball.compiler.middleend.llvmir.constant.IntConst;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.inst.IRICmpInst;
import masterball.compiler.share.lang.LLVM;
import masterball.compiler.share.pass.IRBlockPass;
import masterball.compiler.share.pass.IRFuncPass;

/**
 *  InstAdapter Pass
 *
 *  this pass intends to modify instructions so that it is faster in BackEnd
 *
 */

public class InstAdapter implements IRFuncPass, IRBlockPass {

    @Override
    public void runOnFunc(IRFunction function) {
        function.blocks.forEach(this::runOnBlock);
    }

    @Override
    public void runOnBlock(IRBlock block) {}
}
