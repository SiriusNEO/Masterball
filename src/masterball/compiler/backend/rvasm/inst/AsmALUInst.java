package masterball.compiler.backend.rvasm.inst;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.operand.Immediate;
import masterball.compiler.backend.rvasm.operand.Register;
import masterball.compiler.share.lang.RV32I;

// Arithm and Logic Inst
// add, sub, ...
// slt, seqz, ...

public class AsmALUInst extends AsmBaseInst {
    public final String op;

    public AsmALUInst(String op, Register rd, Register rs1, Register rs2, AsmBlock parentBlock) {
        super(rd, rs1, rs2, null, parentBlock);
        this.op = op;
    }

    public AsmALUInst(String op, Register rd, Register rs1, Immediate imm, AsmBlock parentBlock) {
        super(rd, rs1, null, imm, parentBlock);
        this.op = op;
    }

    public AsmALUInst(String op, Register rd, Register rs1, AsmBlock parentBlock) {
        super(rd, rs1, null, null, parentBlock);
        this.op = op;
    }

    @Override
    public String format() {
        // add rd, rs1, rs2
        // addi rd, rs1, imm
        if (this.imm != null) // I-Type
            return String.format("%s\t%s, %s, %s", op + RV32I.ITypeSuffix, rd, rs1, imm);
        else if (this.rs2 != null) // R-Type
            return String.format("%s\t%s, %s, %s", op, rd, rs1, rs2);
        else
            // unary, maybe pseudo inst
            return String.format("%s\t%s, %s", op, rd, rs1);
    }
}
