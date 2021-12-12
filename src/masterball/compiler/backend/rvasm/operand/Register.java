package masterball.compiler.backend.rvasm.operand;

import masterball.compiler.backend.regalloc.RIG;

public abstract class Register extends BaseOperand {

    // allocated in RegisterAllocator
    public PhysicalReg color;
    // location in stack
    public Immediate stackPos;
    // info in RIG
    public RIG.Node node;

    public Register(String identifier) {
        super(identifier);
    }

}
