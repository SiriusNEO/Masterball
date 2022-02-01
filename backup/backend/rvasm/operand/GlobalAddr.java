package masterball.compiler.backend.rvasm.operand;

// to deal with global variable
// lui  %hi(glb)
// lw	a0, %lo(glb)(a0)

public class GlobalAddr extends Immediate {
    public enum HiLo {hi, lo};

    public GlobalReg reg;

    public GlobalAddr(GlobalReg reg, HiLo hilo) {
        super("%"+String.format("%s(%s)", hilo, reg));
        this.reg = reg;
    }
}
