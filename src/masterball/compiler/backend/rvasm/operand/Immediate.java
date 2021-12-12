package masterball.compiler.backend.rvasm.operand;

public class Immediate extends BaseOperand {
    private final int value;

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
