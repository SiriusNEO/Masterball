package masterball.compiler.middleend.optim;

import masterball.compiler.middleend.llvmir.constant.IntConst;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;
import masterball.compiler.middleend.llvmir.inst.IRBaseInst;
import masterball.compiler.middleend.llvmir.inst.IRCallInst;
import masterball.compiler.middleend.llvmir.inst.IRICmpInst;
import masterball.compiler.share.lang.LLVM;
import masterball.compiler.share.pass.IRBlockPass;
import masterball.compiler.share.pass.IRFuncPass;
import masterball.debug.Log;

import java.util.HashMap;
import java.util.HashSet;

/**
 *  InstAdapter Pass
 *
 *  this pass intends to modify instructions so that it is faster in BackEnd
 *  e.g. <= -> <, by let the rhs+1, because <= costs two instructions
 *
 */

public class InstAdapter implements IRFuncPass, IRBlockPass {

    private IRModule module;

    @Override
    public void runOnFunc(IRFunction function) {
        module = function.parentModule;
        function.blocks.forEach(this::runOnBlock);
    }

    @Override
    public void runOnBlock(IRBlock block) {
        var it = block.instructions.listIterator();

        HashSet<IRBaseInst> toRemove = new HashSet<>();

        while (it.hasNext()) {
            var inst = it.next();
            /*
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
            }*/

            if (inst instanceof IRCallInst && ((IRCallInst) inst).callFunc() == module.getBuiltinFunction("toString")) {
                if (inst.users.size() == 1 && inst.users.get(0) instanceof IRCallInst) {
                    Log.info("hit", inst.format());
                    if (((IRCallInst) inst.users.get(0)).callFunc() == module.getBuiltinFunction("print")) {
                        inst.removedFromAllUsers();
                        block.tSetByIterator(new IRCallInst(module.getBuiltinFunction("printInt"), null, ((IRCallInst) inst).getArg(0)),
                                it);
                        toRemove.add((IRBaseInst) inst.users.get(0));
                    }
                    if (((IRCallInst) inst.users.get(0)).callFunc() == module.getBuiltinFunction("println")) {
                        inst.removedFromAllUsers();
                        block.tSetByIterator(new IRCallInst(module.getBuiltinFunction("printlnInt"), null, ((IRCallInst) inst).getArg(0)),
                                it);
                        toRemove.add((IRBaseInst) inst.users.get(0));
                    }
                }
            }
        }

        toRemove.forEach(inst -> {
            inst.removedFromAllUsers();
            block.instructions.remove(inst);
        });
    }
}
