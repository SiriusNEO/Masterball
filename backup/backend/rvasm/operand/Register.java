package masterball.compiler.backend.rvasm.operand;

import masterball.compiler.backend.regalloc.RIG;

public abstract class Register extends BaseOperand {

    // allocated in RegisterAllocator
    public PhysicalReg color;
    // location in stack
    public Immediate stackOffset;
    // info in InterferenceGraph
    public RIG.Node node = new RIG.Node();

    public Register(String identifier) {
        super(identifier);
    }

}
