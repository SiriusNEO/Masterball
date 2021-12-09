package masterball.compiler.backend.rvasm.inst;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.operand.Immediate;
import masterball.compiler.backend.rvasm.operand.Register;
import masterball.compiler.share.RVTable;

public class AsmJmpInst extends AsmBaseInst {
    private final AsmBlock dest;

    public AsmJmpInst(AsmBlock dest, AsmBlock parentBlock) {
        super(null, null, null, null, parentBlock);
        this.dest = dest;
    }

    @Override
    public String format() {
        // j offset
        return String.format("%s %s", RVTable.JmpInstPrefix, dest);
    }
}
