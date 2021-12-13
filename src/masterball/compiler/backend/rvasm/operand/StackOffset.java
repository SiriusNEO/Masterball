package masterball.compiler.backend.rvasm.operand;

import masterball.debug.Log;

import java.util.HashSet;
import java.util.Set;

public class StackOffset extends Immediate {

    public static Set<StackOffset> collection = new HashSet<>();

    public final int level;
    public boolean setFlag = false;

    public StackOffset(int offset, int level) {
        super(offset);
        this.level = level;
        collection.add(this);
    }

    public void setStackBase(int basePos) {
        if (setFlag) return;
        this.setFlag = true;
        this.value += basePos;
        this.identifier = String.valueOf(this.value);
    }
}
