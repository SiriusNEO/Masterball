package masterball.compiler.backend.rvasm.operand;

import masterball.compiler.share.RVTable;

public class Immediate extends BaseOperand {
    private final int value;

    public Immediate(int value) {
        super(String.valueOf(value));
        this.value = value;
    }
}
