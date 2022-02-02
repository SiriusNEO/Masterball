package masterball.compiler.backend.rvasm.operand;

import masterball.compiler.backend.regalloc.InterferenceGraph;
import masterball.compiler.share.error.runtime.UnknownError;

public abstract class Register extends BaseOperand {

    // assigned in RegisterAllocator
    public PhysicalReg color;
    // location in stack, only spill registers have (graphColor spill & function call spill)
    public RawStackOffset stackOffset;
    // info in InterferenceGraph, used in RegisterAllocator
    public InterferenceGraph.Node node = new InterferenceGraph.Node();

    public Register(String identifier) { super(identifier);}

    @Override
    public String toString() {
        if (color == null) {
            return identifier;
            // throw new UnknownError(this);
        }
        return color.identifier;
        // return identifier;
    }
}
