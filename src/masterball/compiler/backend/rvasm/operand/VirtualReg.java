package masterball.compiler.backend.rvasm.operand;

import masterball.compiler.share.RVTable;

public class VirtualReg extends Register {

    public VirtualReg(int virtualNum) {
        super(RVTable.VirtualRegPrefix + virtualNum);
    }
}
