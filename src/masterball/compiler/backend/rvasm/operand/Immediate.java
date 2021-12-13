package masterball.compiler.backend.rvasm.operand;

public class Immediate extends BaseOperand {
    protected int value;

    public Immediate(int value) {
        super(String.valueOf(value));
        this.value = value;
    }

    // for Global Addr
    protected Immediate(String identifier) {
        super(identifier);
        this.value = 0;
    }
}
