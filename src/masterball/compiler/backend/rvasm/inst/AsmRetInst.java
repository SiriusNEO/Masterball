package masterball.compiler.backend.rvasm.inst;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.share.lang.RV32I;

public class AsmRetInst extends AsmBaseInst {
    public AsmRetInst(AsmBlock parentBlock) {
        super(null, null, null, null, parentBlock);
    }

    @Override
    public String format() {
        return RV32I.RetInst;
    }
}
