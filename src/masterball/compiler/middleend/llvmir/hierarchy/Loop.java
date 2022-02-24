package masterball.compiler.middleend.llvmir.hierarchy;

import masterball.compiler.middleend.analyzer.AliasAnalyzer;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.constant.BaseConst;
import masterball.compiler.middleend.llvmir.inst.*;

import java.util.HashSet;

public class Loop {
    public IRBlock preHeader;
    public IRBlock header;
    public HashSet<IRBlock> tailers = new HashSet<>();
    public HashSet<IRBlock> blocks = new HashSet<>();

    public Loop fatherLoop;
    public HashSet<Loop> nestedLoops = new HashSet<>();

    public Loop(IRBlock header) {
        this.header = header;
    }

    public void addBlock(IRBlock block) {
        block.belongLoop = this;
        this.blocks.add(block);
    }

    public void addNestedLoop(Loop subLoop) {
        this.nestedLoops.add(subLoop);
        subLoop.fatherLoop = this;
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

    public boolean isInstInvariant(IRBaseInst inst, AliasAnalyzer analyzer) {
        if ((inst.mayHaveSideEffects() && !(inst instanceof IRLoadInst)) || !inst.isValueSelf()) return false;

        for (Value operand : inst.operands) {
            if (!this.isInvariant(operand)) {
                // Log.mark("not invariant");
                // Log.info(inst.format());
                // Log.info(operand.identifier());
                return false;
            }
        }

        if (inst instanceof IRLoadInst) {
            for (IRBlock block : this.blocks)
                for (IRBaseInst inst1 : block.instructions) {
                    if (inst1 instanceof IRStoreInst &&
                            analyzer.mayAlias(((IRLoadInst) inst).loadPtr(), ((IRStoreInst) inst1).storePtr())) {
                        // Log.mark("may alias");
                        // Log.info("load: ", ((IRLoadInst) inst).loadPtr().typedIdentifier());
                        // Log.info("store", ((IRStoreInst) inst1).storePtr().typedIdentifier());
                        return false;
                    }

                    if (inst1 instanceof IRCallInst) return false;
                }
        }

        return true;
    }
}
