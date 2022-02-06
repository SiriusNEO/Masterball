package masterball.compiler.backend.rvasm.inst;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.operand.Register;
import masterball.compiler.share.lang.RV32I;

// no beqz now

public class AsmBrInst extends AsmBaseInst {
    String op;
    public AsmBlock dest;

    public AsmBrInst(String op, Register rs1, Register rs2, AsmBlock dest, AsmBlock parentBlock) {
        super(null, rs1, rs2, null, parentBlock);
        this.op = op;
        this.dest = dest;
    }

    @Override
    public String format() {
        // beq rs1, rs2, dest
        return String.format("%s\t%s, %s, %s", RV32I.BrInstPrefix + op, rs1, rs2, dest);
    }
}
