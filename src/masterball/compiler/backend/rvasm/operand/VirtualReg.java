package masterball.compiler.backend.rvasm.operand;

import masterball.compiler.share.lang.RV32I;

public class VirtualReg extends Register {

    public static int virtualRegNum = 0;
    public static void regNumReset() {
        virtualRegNum = 0;
    }

    public final int size;

    public VirtualReg() {
        super(RV32I.VirtualRegPrefix + virtualRegNum++);
        this.size = 4;
    }

    public VirtualReg(int size) {
        super(RV32I.VirtualRegPrefix + virtualRegNum++);
        this.size = size;
    }
}
