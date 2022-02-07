package masterball.compiler.backend.rvasm.operand;

public class Immediate extends BaseOperand {
    public int value;

    public Immediate(int value) {
        super(String.valueOf(value));
        this.value = value;
    }

    public Immediate negative() {
        return new Immediate(-value);
    }

    // for Global Addr
    protected Immediate(String identifier) {
        super(identifier);
        this.value = 0;
    }
}
