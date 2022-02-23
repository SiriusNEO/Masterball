package masterball.compiler.backend.rvasm.inst;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.operand.Immediate;
import masterball.compiler.backend.rvasm.operand.Register;
import masterball.compiler.share.lang.RV32I;

public class AsmLuiInst extends AsmBaseInst {
    public AsmLuiInst(Register rd, Immediate imm, AsmBlock parentBlock) {
        super(rd, null, null, imm, parentBlock);
    }

    @Override
    public AsmBaseInst copy() {
        return new AsmLuiInst(rd, imm, null);
    }

    @Override
    public String format() {
        // lui	a0, %hi(glb)
        return String.format("%s\t%s, %s", RV32I.LuiInst, rd, imm);
    }
}
