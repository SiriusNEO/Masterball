package masterball.compiler.backend.rvasm.inst;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.operand.PhysicalReg;
import masterball.compiler.backend.rvasm.operand.Register;
import masterball.compiler.share.lang.RV32I;

import java.util.HashSet;

public class AsmRetInst extends AsmBaseInst {
    public AsmRetInst(AsmBlock parentBlock) {
        super(null, null, null, null, parentBlock);
        // ret use "ra"
    }

    @Override
    public HashSet<Register> uses() {
        HashSet<Register> ret = new HashSet<Register>();
        ret.add(PhysicalReg.reg("ra"));
        return ret;
    }

    @Override
    public String format() {
        return RV32I.RetInst;
    }
}
