package masterball.compiler.backend.optim;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.inst.AsmBaseInst;
import masterball.compiler.backend.rvasm.inst.AsmMvInst;
import masterball.compiler.share.pass.AsmFuncPass;

import java.util.HashSet;

public class CoalesceMoves implements AsmFuncPass {
    @Override
    public void runOnFunc(AsmFunction function) {
        for (AsmBlock block : function.blocks) {
            block.instructions.removeIf(inst -> inst instanceof AsmMvInst && inst.rd.color == inst.rs1.color);
        }

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
}
