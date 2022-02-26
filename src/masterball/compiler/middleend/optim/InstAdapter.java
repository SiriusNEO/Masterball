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
 *  e.g. <= -> <, by let the rhs+1, because <= costs two instructions
 *
 */

public class InstAdapter implements IRFuncPass, IRBlockPass {

    @Override
    public void runOnFunc(IRFunction function) {
        function.blocks.forEach(this::runOnBlock);
    }

    @Override
    public void runOnBlock(IRBlock block) {
        var it = block.instructions.listIterator();

        while (it.hasNext()) {
            var inst = it.next();

            if (inst instanceof IRICmpInst && (((IRICmpInst) inst).lhs() instanceof IntConst || ((IRICmpInst) inst).rhs() instanceof IntConst)) {
                if (((IRICmpInst) inst).op.equals(LLVM.LessEqualArg)) {
                    ((IRICmpInst) inst).op = LLVM.LessArg;
                    if (((IRICmpInst) inst).rhs() instanceof IntConst)
                        ((IntConst) ((IRICmpInst) inst).rhs()).constData += 1;
                    else
                        ((IntConst) ((IRICmpInst) inst).lhs()).constData -= 1;
                } else if (((IRICmpInst) inst).op.equals(LLVM.GreaterEqualArg)) {
                    ((IRICmpInst) inst).op = LLVM.GreaterArg;
                    if (((IRICmpInst) inst).rhs() instanceof IntConst)
                        ((IntConst) ((IRICmpInst) inst).rhs()).constData -= 1;
                    else
                        ((IntConst) ((IRICmpInst) inst).lhs()).constData += 1;
                }
            }
        }
    }
}
