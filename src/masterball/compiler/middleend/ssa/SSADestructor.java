package masterball.compiler.middleend.ssa;

import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.inst.IRBrInst;
import masterball.compiler.middleend.llvmir.inst.IRMoveInst;
import masterball.compiler.middleend.llvmir.inst.IRPhiInst;
import masterball.compiler.share.lang.LLVM;
import masterball.compiler.share.pass.IRFuncPass;
import masterball.debug.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class SSADestructor implements IRFuncPass {

    private final HashMap<IRBlock, CopyGraph> copyGraphMap = new HashMap<>();

    // critical path: fromBlock -> toBlock
    // notice: ConcurrentModificationException
    private void criticalEdgeSplit(IRFunction function) {
        ArrayList<IRBlock> midBlockLists = new ArrayList<>();
        HashMap<IRBlock, IRBlock> redirectPreLists = new HashMap<>();

        for (IRBlock fromBlock : function.blocks) {
            var successors = fromBlock.nexts;
            if (successors.size() <= 1) continue;

            for (IRBlock toBlock : successors) {
                if (toBlock.prevs.size() <= 1) continue;
                // fromBlock -> midBlock -> toBlock
                IRBlock midBlock = new IRBlock(LLVM.MidBlockLabel, null);

                midBlock.parentFunction = function; // add manually

                midBlockLists.add(midBlock);
                redirectPreLists.put(toBlock, midBlock);
                new IRBrInst(toBlock, midBlock); // jump to toBlock

                midBlock.prevs.add(fromBlock);
                midBlock.nexts.add(toBlock);
                toBlock.redirectSucBlock(fromBlock, midBlock);
            }

            // from block suc fix
            redirectPreLists.forEach((to, mid) -> fromBlock.redirectPreBlock(to, mid));
            redirectPreLists.clear();
        }
        function.blocks.addAll(midBlockLists);
    }

    // resolve phi and generate para copies
    private void buildCopyGraph(IRFunction function) {
       function.blocks.forEach(block -> copyGraphMap.put(block, new CopyGraph()));
       for (IRBlock block : function.blocks) {
           for (IRPhiInst phi : block.phiInsts) {
               for (int i = 0; i < phi.operandSize(); i += 2) {
                   // insert in the graph of preds
                   copyGraphMap.get((IRBlock) phi.getOperand(i + 1)).
                           insert(new CopyGraph.CopyEdge(phi, phi.getOperand(i)));
               }
           }
       }
    }

    // copy -> move inst
    // notice: ConcurrentModificationException
    // first eliminate all free nodes (whose in_degree in the graph == 0)
    private void eliminateFreeNode(IRBlock block, CopyGraph copyGraph) {
        boolean hasFreeNode = true;
        while (hasFreeNode) {
            hasFreeNode = false;
            for (var it = copyGraph.edges.iterator(); it.hasNext(); ) {
                CopyGraph.CopyEdge nowCopy = it.next();
                if (copyGraph.isFree(nowCopy.dest)) {
                    var move = new IRMoveInst(nowCopy.dest, nowCopy.source, block);// terminated
                    if (!block.instructions.isEmpty()) {
                        block.instructions.add(block.instructions.size() - 1, move);
                    }
                    copyGraph.remove(nowCopy, it);
                    hasFreeNode = true;
                }
            }
        }
    }
    // turn copy to move inst
    // if there is a loop, use a mid dest to break the loop
    public void copyToMove(IRBlock block, CopyGraph copyGraph) {
        boolean loopBreak = true;

        while (loopBreak) {
            loopBreak = false;
            eliminateFreeNode(block, copyGraph);
            for (var it = copyGraph.edges.iterator(); it.hasNext(); ) {
                CopyGraph.CopyEdge nowCopy = it.next();
                if (nowCopy.isLoop()) continue; // move A A
                copyGraph.remove(nowCopy, it);
                Value midDest = new Value(LLVM.Anon, nowCopy.dest.type); // a new dest
                copyGraph.insert(new CopyGraph.CopyEdge(nowCopy.dest, midDest));

                var move = new IRMoveInst(midDest, nowCopy.source, block); // terminated
                if (!block.instructions.isEmpty()) {
                    block.instructions.add(block.instructions.size() - 1, move);
                }

                loopBreak = true; // after breaking the loop, the graph should be processed again
                break;
            }
        }
    }

    @Override
    public void runOnFunc(IRFunction function) {
        criticalEdgeSplit(function);
        buildCopyGraph(function);
        copyGraphMap.forEach(this::copyToMove);
    }
}
