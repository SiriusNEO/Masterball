package masterball.compiler.backend.rvasm.inst;

import masterball.compiler.backend.rvasm.AsmTranslator;
import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.operand.Immediate;
import masterball.compiler.backend.rvasm.operand.Register;
import masterball.compiler.share.RVTable;

public class AsmStoreInst extends AsmBaseInst {
    private final int byteWidth;

    public AsmStoreInst(int byteWidth, Register rs1, Register rs2, Immediate imm, AsmBlock parentBlock) {
        super(null, rs1, rs2, imm, parentBlock);
        this.byteWidth = byteWidth;
    }

    @Override
    public String format() {
        return String.format("%s %s %s %s",
                RVTable.StoreInstPrefix + AsmTranslator.translateByteWidth(byteWidth), rs1, rs2, imm);
    }
}
