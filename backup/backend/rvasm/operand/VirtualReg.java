package masterball.compiler.backend.rvasm.operand;

import masterball.compiler.share.lang.RV32I;

public class VirtualReg extends Register {

    public static int virtualRegNum = 0;
    public static void regNumReset() {
        virtualRegNum = 0;
    }

    public final int num, size;

    public VirtualReg() {
        super(RV32I.VirtualRegPrefix + virtualRegNum);
        this.num = virtualRegNum;
        this.size = 4;
        virtualRegNum++;
    }

    public VirtualReg(int size) {
        super(RV32I.VirtualRegPrefix + virtualRegNum);
        this.num = virtualRegNum;
        this.size = size;
        virtualRegNum++;
    }
}
