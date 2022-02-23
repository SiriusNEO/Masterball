package masterball.compiler.backend.rvasm.inst;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.operand.Register;
import masterball.compiler.share.lang.RV32I;

public class AsmMvInst extends AsmBaseInst {
    public AsmMvInst(Register rd, Register rs1, AsmBlock parentBlock) {
        super(rd, rs1, null, null, parentBlock);
    }

    @Override
    public AsmBaseInst copy() {
        return new AsmMvInst(rd, rs1, null);
    }

    @Override
    public String format() {
        // mv rd, rs1
        return String.format("%s\t%s, %s", RV32I.MvInst, rd, rs1);
    }
}
