package masterball.compiler.backend.rvasm.inst;

import masterball.compiler.backend.rvasm.AsmTranslator;
import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.operand.Immediate;
import masterball.compiler.backend.rvasm.operand.Register;
import masterball.compiler.share.RVTable;

public class AsmLoadInst extends AsmBaseInst {
    private final int byteWidth;

    public AsmLoadInst(int byteWidth, Register rd, Register rs1, Register rs2, Immediate imm, AsmBlock parentBlock) {
        super(rd, rs1, rs2, imm, parentBlock);
        this.byteWidth = byteWidth;
    }

    @Override
    public String format() {
        return String.format("%s %s %s %s",
                RVTable.LoadInstPrefix + AsmTranslator.translateByteWidth(byteWidth), rs1, rs2, imm);
    }
}
