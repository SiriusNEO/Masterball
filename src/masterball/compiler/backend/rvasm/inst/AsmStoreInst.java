package masterball.compiler.backend.rvasm.inst;

import masterball.compiler.backend.rvasm.AsmTranslator;
import masterball.compiler.backend.rvasm.hierarchy.ASMBlock;
import masterball.compiler.backend.rvasm.operand.Immediate;
import masterball.compiler.backend.rvasm.operand.Register;

public class AsmStoreInst extends AsmBaseInst {

    public AsmStoreInst(int byteWidth, Register rs1, Register rs2, Immediate imm, ASMBlock parentBlock) {
        super("s" + AsmTranslator.translateByteWidth(byteWidth),
                 null, rs1, rs2, imm, parentBlock);
    }

    @Override
    public String format() {
        return String.format("%s %s %s %s", name, rs1, rs2, imm);
    }
}
