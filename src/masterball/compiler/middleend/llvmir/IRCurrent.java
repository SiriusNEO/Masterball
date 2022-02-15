package masterball.compiler.middleend.llvmir;

import masterball.compiler.frontend.info.registry.ClassRegistry;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.inst.IRBrInst;
import masterball.compiler.share.lang.MxStar;
import masterball.compiler.share.error.runtime.InternalError;

import java.util.Stack;

public class IRCurrent {
    // current pointer
    public IRBlock block = null;
    public IRFunction func = null;
    public ClassRegistry classRegistry = null;

    // break/continue support
    private final Stack<IRBlock> contTargetBlocks = new Stack<>(),
                                    breakTargetBlocks = new Stack<>();

    public void terminateAllBlocks() {
        for (IRBlock block : this.func.blocks)
            if (!block.isTerminated) new IRBrInst(this.func.exitBlock, block);
    }

    public void loopSetKeywordTarget(IRBlock contTargetBlock, IRBlock breakTargetBlock) {
        contTargetBlocks.push(contTargetBlock);
        breakTargetBlocks.push(breakTargetBlock);
    }

    public void loopPopKeywordTarget() {
        contTargetBlocks.pop();
        breakTargetBlocks.pop();
    }

    public void setControlBr(String controlWord) {
        switch (controlWord) {
            case MxStar.continueKw:
                new IRBrInst(contTargetBlocks.peek(), block);
                break;
            case MxStar.breakKw:
                new IRBrInst(breakTargetBlocks.peek(), block);
                break;
            default: throw new InternalError(controlWord);
        }
    }

    public Value getThis() {
        if (this.classRegistry == null || this.func == null) throw new InternalError("IR this appears in not in a class");
        return this.func.getOperand(0);
    }
}
