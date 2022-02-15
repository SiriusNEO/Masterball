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
    }
}
