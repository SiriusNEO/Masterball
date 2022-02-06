package masterball.compiler.backend.rvasm.inst;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.share.lang.RV32I;

public class AsmJmpInst extends AsmBaseInst {
    public AsmBlock dest;

    public AsmJmpInst(AsmBlock dest, AsmBlock parentBlock) {
        super(null, null, null, null, parentBlock);
        this.dest = dest;
    }

    @Override
    public String format() {
        // j offset
        return String.format("%s\t%s", RV32I.JmpInstPrefix, dest);
    }
}
