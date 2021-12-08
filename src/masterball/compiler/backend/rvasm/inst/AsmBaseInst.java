package masterball.compiler.backend.rvasm.inst;

import masterball.compiler.backend.rvasm.hierarchy.ASMBlock;
import masterball.compiler.backend.rvasm.operand.Immediate;
import masterball.compiler.backend.rvasm.operand.Register;

public abstract class AsmBaseInst {
    String name;
    Register rd, rs1, rs2;
    Immediate imm;

    public AsmBaseInst(String name, Register rd, Register rs1, Register rs2, Immediate imm, ASMBlock parentBlock) {
        this.name = name;
        this.rd = rd;
        this.rs1 = rs1;
        this.rs2 = rs2;
        this.imm = imm;
        parentBlock.addInst(this);
    }

    public abstract String format();

}
