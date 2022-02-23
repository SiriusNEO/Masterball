package masterball.compiler.backend.rvasm.inst;

import masterball.compiler.backend.rvasm.AsmTranslator;
import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.operand.Immediate;
import masterball.compiler.backend.rvasm.operand.Register;
import masterball.compiler.share.lang.RV32I;

public class AsmStoreInst extends AsmBaseInst {
    private final int byteWidth;

    public AsmStoreInst(int byteWidth, Register rs1, Register rs2, Immediate imm, AsmBlock parentBlock) {
        super(null, rs1, rs2, imm, parentBlock);
        this.byteWidth = byteWidth;
    }

    @Override
    public AsmBaseInst copy() {
        return new AsmStoreInst(byteWidth, rs1, rs2, imm, null);
    }

    @Override
    public String format() {
        // sw rs2, offset(rs1)
        return String.format("%s\t%s, %s(%s)",
                RV32I.StoreInstPrefix + AsmTranslator.translateByteWidth(byteWidth), rs2, imm, rs1);
    }
}
