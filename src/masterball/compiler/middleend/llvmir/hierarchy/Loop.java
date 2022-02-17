package masterball.compiler.middleend.llvmir.hierarchy;

import masterball.compiler.middleend.analyzer.LoopAnalyzer;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.constant.BaseConst;
import masterball.compiler.middleend.llvmir.inst.IRBaseInst;
import masterball.compiler.middleend.llvmir.inst.IRMoveInst;

import java.util.HashSet;

public class Loop {
    public IRBlock head;
    public HashSet<IRBlock> blocks = new HashSet<>();
    public HashSet<Loop> nestedLoops = new HashSet<>();

    public Loop(IRBlock head) {
        this.head = head;
    }

    public boolean isInvariant(Value value) {
        // const: true
        if (value instanceof BaseConst) return true;

        // inst: no def in loop
        if (value instanceof IRBaseInst) {
            return !blocks.contains(((IRBaseInst) value).parentBlock);
        }

        // warning: no move
        for (IRMoveInst move : value.moveDefs) {
            if (blocks.contains(move.parentBlock)) return false;
        }

        return true;
    }
}
