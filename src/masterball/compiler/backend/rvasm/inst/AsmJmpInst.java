package masterball.compiler.backend.rvasm.inst;

import masterball.compiler.backend.rvasm.hierarchy.ASMBlock;
import masterball.compiler.backend.rvasm.operand.Immediate;
import masterball.compiler.backend.rvasm.operand.Register;

public class AsmJmpInst extends AsmBaseInst {
    public AsmJmpInst(String name, Register rd, Register rs1, Register rs2, Immediate imm, ASMBlock parentBlock) {
        super(name, rd, rs1, rs2, imm, parentBlock);
    }

    @Override
    public String format() {
        return null;
    }
}
