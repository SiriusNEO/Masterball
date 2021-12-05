package masterball.compiler.middleend.llvmir;

import masterball.compiler.frontend.info.registry.ClassRegistry;
import masterball.compiler.middleend.llvmir.hierarchy.BaseValue;
import masterball.compiler.middleend.llvmir.hierarchy.BasicBlock;
import masterball.compiler.middleend.llvmir.hierarchy.Function;
import masterball.compiler.middleend.llvmir.inst.AllocaInst;
import masterball.compiler.middleend.llvmir.inst.BrInst;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.utils.MxStarTable;
import masterball.compiler.utils.error.runtime.UnknownError;

import java.util.Stack;

public class CurrentCarrier {

    // current pointer
    public BasicBlock block = null;
    public Function func = null;
    public ClassRegistry classRegistry = null;
    public BaseValue retValPtr = null;

    // break/continue support
    private final Stack<BasicBlock> contTargetBlocks = new Stack<>(),
                                    breakTargetBlocks = new Stack<>();

    public void terminateAllBlocks() {
        for (BasicBlock block : this.func.blocks)
            if (!block.isTerminated) new BrInst(this.func.exitBlock(), block);
    }

    public void loopSetKeywordTarget(BasicBlock contTargetBlock, BasicBlock breakTargetBlock) {
        contTargetBlocks.push(contTargetBlock);
        breakTargetBlocks.push(breakTargetBlock);
    }

    public void loopPopKeywordTarget() {
        contTargetBlocks.pop();
        breakTargetBlocks.pop();
    }

    public void setControlBr(String controlWord) {
        switch (controlWord) {
            case MxStarTable.continueKw:
                new BrInst(contTargetBlocks.peek(), block);
                break;
            case MxStarTable.breakKw:
                new BrInst(breakTargetBlocks.peek(), block);
                break;
            default: throw new UnknownError(controlWord);
        }
    }

    public BaseValue getThis() {
        if (this.classRegistry == null || this.func == null) throw new UnknownError(this);
        return this.func.getOperand(0);
    }
}
