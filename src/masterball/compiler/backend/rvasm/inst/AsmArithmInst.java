package masterball.compiler.backend.rvasm.inst;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.operand.Immediate;
import masterball.compiler.backend.rvasm.operand.Register;

public class AsmArithmInst extends AsmBaseInst {
    private final String op;
    public AsmArithmInst(String op, Register rd, Register rs1, Register rs2, Immediate imm, AsmBlock parentBlock) {
        super(rd, rs1, rs2, imm, parentBlock);
        this.op = op;
    }

    @Override
    public String format() {
        // add rd, rs1, rs2
        // addi rd, rs1, imm
        if (this.imm != null) // I-Type
            return String.format("%s %s, %s, %s", op, rd, rs1, imm);
        // R-Type
        return String.format("%s %s %s %s", op, rd, rs1, rs2);
    }
}
