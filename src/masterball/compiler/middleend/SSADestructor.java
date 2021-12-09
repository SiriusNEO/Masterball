package masterball.compiler.middleend;

import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.hierarchy.Value;
import masterball.compiler.middleend.llvmir.inst.IRBrInst;
import masterball.compiler.middleend.llvmir.inst.IRMoveInst;
import masterball.compiler.middleend.llvmir.inst.IRPhiInst;
import masterball.compiler.middleend.pass.IRFuncPass;
import masterball.compiler.middleend.utils.CopyGraph;
import masterball.compiler.share.LLVMTable;

import java.util.ArrayList;
import java.util.HashMap;

public class SSADestructor extends IRFuncPass {

    private final HashMap<IRBlock, CopyGraph> copyGraphMap = new HashMap<>();

    // critical path: fromBlock -> toBlock
    // notice: ConcurrentModificationException
    private void criticalEdgeSplit(IRFunction function) {
        ArrayList<IRBlock> midBlockLists = new ArrayList<>();
        HashMap<IRBlock, IRBlock> relinkLists = new HashMap<>();

        for (IRBlock fromBlock : function.blocks) {
            var successors = fromBlock.nexts;
            if (successors.size() <= 1) continue;

            for (IRBlock toBlock : successors) {
                if (toBlock.prevs.size() <= 1) continue;
                // fromBlock -> midBlock -> toBlock
                IRBlock midBlock = new IRBlock(LLVMTable.MidBlockLabel, null);
                midBlockLists.add(midBlock);
                relinkLists.put(toBlock, midBlock);
                new IRBrInst(toBlock, midBlock); // jump to toBlock

                // revise phi fromBlocks
                for (IRPhiInst inst : toBlock.phiInsts) {
                    for (int i = 0; i < inst.operandSize(); i += 2)
                        if (inst.getOperand(i+1) == fromBlock)
                            inst.resetOperand(i+1, midBlock);
                }
            }
            relinkLists.forEach(fromBlock::relinkBlock);
        }
        function.blocks.addAll(midBlockLists);
    }

    // resolve phi and generate para copies
    private void buildCopyGraph(IRFunction function) {
       function.blocks.forEach(block -> copyGraphMap.put(block, new CopyGraph()));
       for (IRBlock block : function.blocks) {
           for (IRPhiInst phi : block.phiInsts) {
               for (int i = 0; i < phi.operandSize(); i += 2)
                   // insert in the graph of preds
                   copyGraphMap.get((IRBlock) phi.getOperand(i + 1)).
                           insert(new CopyGraph.CopyEdge(phi, phi.getOperand(i)));
           }
       }
    }

    // copy -> move inst
    // notice: ConcurrentModificationException
    private void eliminateFreeNode(IRBlock block, CopyGraph copyGraph) {
        boolean hasFreeNode = true;
        while (hasFreeNode) {
            hasFreeNode = false;
            for (var it = copyGraph.edges.iterator(); it.hasNext(); ) {
                CopyGraph.CopyEdge nowCopy = it.next();
                if (copyGraph.isfree(nowCopy.dest)) {
                    new IRMoveInst(nowCopy.dest, nowCopy.source, block);
                    copyGraph.remove(nowCopy, it);
                    hasFreeNode = true;
                }
            }
        }
    }

    private void copyToMove(IRBlock block, CopyGraph copyGraph) {
        boolean loopBreak = true;
        while (loopBreak) {
            loopBreak = false;
            eliminateFreeNode(block, copyGraph);

            // graph -> ring, create mid dest to break the loop
            for (var it = copyGraph.edges.iterator(); it.hasNext(); ) {
                CopyGraph.CopyEdge nowCopy = it.next();
                if (nowCopy.isLoop()) continue; // move A A
                copyGraph.remove(nowCopy, it);
                Value midDest = new Value(LLVMTable.Anon, nowCopy.dest.type); // a new dest
                copyGraph.insert(new CopyGraph.CopyEdge(nowCopy.dest, midDest));
                new IRMoveInst(midDest, nowCopy.source, block);
                loopBreak = true; // after breaking the loop, the graph should be processed again
                break;
            }
        }
    }

    @Override
    public void pass(IRFunction function) {
        criticalEdgeSplit(function);
        buildCopyGraph(function);
        copyGraphMap.forEach(this::copyToMove);
    }
}
