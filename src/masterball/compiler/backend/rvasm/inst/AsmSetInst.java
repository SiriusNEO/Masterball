package masterball.compiler.backend.rvasm.inst;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.operand.Immediate;
import masterball.compiler.backend.rvasm.operand.Register;

public class AsmSetInst extends AsmBaseInst{
    public AsmSetInst(Register rd, Register rs1, Register rs2, Immediate imm, AsmBlock parentBlock) {
        super(rd, rs1, rs2, imm, parentBlock);
    }

    @Override
    public String format() {
        return null;
    }
}
