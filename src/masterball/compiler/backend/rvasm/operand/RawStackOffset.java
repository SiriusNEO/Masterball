package masterball.compiler.backend.rvasm.operand;
import masterball.compiler.share.error.runtime.UnknownError;

// RawStackOffset will be turned to Immediate with correct position
// throw an error if there is RawStackOffset not be eliminated

public class RawStackOffset extends Immediate {

    public enum RawType {callerArg, alloca, spill, calleeArg, lowerSp, raiseSp};
    public RawType level;

    public RawStackOffset(int offset, RawType level) {
        super(offset);
        this.level = level;
    }

    /*
    @Override
    public String toString() {
        throw new UnknownError(this);
    }
    */
}
