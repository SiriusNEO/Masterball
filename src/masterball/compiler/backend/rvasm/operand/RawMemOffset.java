package masterball.compiler.backend.rvasm.operand;

import masterball.compiler.middleend.llvmir.Value;

public class RawMemOffset extends Immediate {
    public Register pointer;

    public RawMemOffset(Register pointer, int offset) {
        super(offset);
        this.pointer = pointer;
    }
}
