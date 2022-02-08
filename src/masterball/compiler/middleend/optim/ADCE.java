package masterball.compiler.middleend.optim;

import masterball.compiler.middleend.analyzer.DomTreeBuilder;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.inst.IRBaseInst;
import masterball.compiler.middleend.llvmir.inst.IRBrInst;
import masterball.compiler.middleend.llvmir.inst.IRLoadInst;
import masterball.compiler.share.pass.IRFuncPass;

import java.util.*;

/**
 *  Aggressive Dead Code Elimination Pass
 *
 *  all instructions and blocks are marked dead at first
 *  Notice: if a block is live, it's control dependencies are live
 *  Control Dependence = DF of the postDomTree
 *
 * @reference: LLVM project /lib/Transforms/Scalar/ADCE.cpp
 */

public class ADCE implements IRFuncPass {

    private final Queue<IRBaseInst> instWorklist = new LinkedList<>();

    private final Set<IRBaseInst> liveInst = new HashSet<>();
    private final Set<IRBlock> liveBlock = new HashSet<>();

    private List<IRBlock> getCD(IRBlock block) {
        return block.dtNode.domFrontier;
    }

    private boolean isAlwaysLive(IRBaseInst inst) {
        // special for load inst
        return inst.mayHaveSideEffects() && !(inst instanceof IRLoadInst);
    }

    private void init(IRFunction function) {
        new DomTreeBuilder(true).runOnFunc(function);

        for (IRBlock block : function.blocks)
            for (IRBaseInst inst : block.instructions)
                if (isAlwaysLive(inst)) markInstLive(inst);
    }

    private void markInstLive(IRBaseInst inst) {
        if (!liveInst.contains(inst)) {
            liveInst.add(inst);
            instWorklist.offer(inst);
        }
    }

    private void markBranch(IRBlock block) {
        if (!liveBlock.contains(block)) {
            liveBlock.add(block);
            markInstLive(block.terminator());
        }
    }

    private void markBlockLive(IRBlock block) {
        if (!liveBlock.contains(block)) {
            liveBlock.add(block);
            for (IRBlock cd : getCD(block))
                markBlockLive(cd);
        }
    }

    @Override
    public void runOnFunc(IRFunction function) {
        init(function);

        while (!instWorklist.isEmpty()) {
            IRBaseInst inst = instWorklist.poll();
            markInstLive(inst);
            markBlockLive(inst.parentBlock);
            inst.operands.forEach(operand -> {
                if (operand instanceof IRBaseInst) markInstLive((IRBaseInst) operand);
                else if (operand instanceof IRBlock) markBranch((IRBlock) operand);
            });
        }

        for (IRBlock block : function.blocks) {
            var it = block.instructions.iterator();
            while (it.hasNext()) {
                var inst = it.next();
                if (!liveInst.contains(inst)) {
                    if (inst.isTerminator()) {
                        if (inst instanceof IRBrInst && !((IRBrInst) inst).isJump()) {
                            IRBlock newDest = block.dtNode.idom.fromBlock;
                            while (!liveBlock.contains(newDest)) newDest = newDest.dtNode.idom.fromBlock;
                            inst.removedFromUser();
                            block.tReplaceTerminator(new IRBrInst(newDest, null));
                        }
                    } else {
                        inst.removedFromUser();
                        it.remove();
                    }
                }
            }
        }
    }
}
