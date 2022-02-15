package masterball.compiler.backend.optim;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.inst.AsmALUInst;
import masterball.compiler.backend.rvasm.inst.AsmBaseInst;
import masterball.compiler.backend.rvasm.inst.AsmMvInst;
import masterball.compiler.backend.rvasm.operand.Immediate;
import masterball.compiler.share.lang.LLVM;
import masterball.compiler.share.pass.AsmFuncPass;

import java.util.HashSet;
import java.util.Objects;

public class InstFolding implements AsmFuncPass {

    private void foldMoves(AsmFunction function) {
        for (AsmBlock block : function.blocks) {
            HashSet<AsmBaseInst> toRemoveSet = new HashSet<>();

            for (int i = 0; i < block.instructions.size()-1; i++)
                if (block.instructions.get(i) instanceof AsmMvInst && block.instructions.get(i+1) instanceof AsmMvInst &&
                        block.instructions.get(i).rd.color == block.instructions.get(i+1).rd.color &&
                        block.instructions.get(i).rs1.color == block.instructions.get(i+1).rs1.color) {
                    toRemoveSet.add(block.instructions.get(i+1));
                }

            block.instructions.removeAll(toRemoveSet);
        }
    }

    private boolean isValidAddi(AsmBaseInst inst) {
        return inst instanceof AsmALUInst && Objects.equals(((AsmALUInst) inst).op, LLVM.AddInst) && inst.imm != null && inst.rd.color == inst.rs1.color;
    }

    private void foldAddi(AsmFunction function) {
        for (AsmBlock block : function.blocks) {
            HashSet<AsmBaseInst> toRemoveSet = new HashSet<>();

            for (int i = 0; i < block.instructions.size()-1; i++)
                if (isValidAddi(block.instructions.get(i)) &&
                    isValidAddi(block.instructions.get(i+1)) &&
                    block.instructions.get(i).rd.color == block.instructions.get(i+1).rd.color) {
                    toRemoveSet.add(block.instructions.get(i));
                    block.instructions.get(i+1).imm = new Immediate(block.instructions.get(i).imm.value + block.instructions.get(i+1).imm.value);
                }

            block.instructions.removeAll(toRemoveSet);
        }
    }

    @Override
    public void runOnFunc(AsmFunction function) {
        foldMoves(function);
        foldAddi(function);
    }
}
