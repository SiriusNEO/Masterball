package masterball.compiler.backend.rvasm.inst;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.operand.PhysicalReg;
import masterball.compiler.share.lang.RV32I;

public class AsmRetInst extends AsmBaseInst {
    public AsmRetInst(AsmBlock parentBlock) {
        super(null, null, null, null, parentBlock);

        // ret use "ra"

        this.uses.add(PhysicalReg.reg("ra"));
    }

    @Override
    public String format() {
        return RV32I.RetInst;
    }
}
