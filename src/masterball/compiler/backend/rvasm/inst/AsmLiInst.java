package masterball.compiler.backend.rvasm.inst;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.operand.Immediate;
import masterball.compiler.backend.rvasm.operand.Register;
import masterball.compiler.share.RVTable;

public class AsmLiInst extends AsmBaseInst {
    public AsmLiInst(Register rd, Immediate imm, AsmBlock parentBlock) {
        super(rd, null, null, imm, parentBlock);
    }

    @Override
    public String format() {
        return String.format("%s %s %s", RVTable.LiInst, rd, imm);
    }
}
