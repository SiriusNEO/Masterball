package masterball.compiler.backend.rvasm.operand;

public class GlobalReg extends Register {
    public String stringConst;

    public GlobalReg(String identifier) {
        super(identifier);
    }

    public GlobalReg(String identifier, String stringConst) {
        super(identifier);
        this.stringConst = stringConst;
    }
}
