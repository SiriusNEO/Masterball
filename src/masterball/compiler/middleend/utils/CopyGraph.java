package masterball.compiler.middleend.utils;

import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.Value;
import masterball.compiler.middleend.llvmir.inst.IRMoveInst;

import java.util.ArrayList;
import java.util.HashMap;

public class CopyGraph {
    public static class Copy {
        public Value dest, source;

        public Copy(Value dest, Value source) {
            this.dest = dest;
            this.source = source;
        }

        public boolean isLoop() {
            return dest.equals(source);
        }

    }

    public final ArrayList<Copy> copyList = new ArrayList<>();
    private final HashMap<Value, Integer> inDegree = new HashMap<>();

    public CopyGraph() {}

    public void insert(Copy copy) {
        copyList.add(copy);
        if (!inDegree.containsKey(copy.source)) inDegree.put(copy.source, 1);
        else inDegree.put(copy.source, inDegree.get(copy.source) + 1);
    }

    // use iterator because we are doing for-loop
    public void remove(Copy copy) {
        if (inDegree.get(copy.source) == 1) inDegree.remove(copy.source);
        else inDegree.put(copy.source, inDegree.get(copy.source) - 1);
    }

    public boolean isfree(Value dest) {
        return !inDegree.containsKey(dest);
    }

}
