package masterball.compiler.backend.optim;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.inst.*;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.share.pass.AsmFuncPass;
import masterball.debug.Log;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  Tail Call Optimization
 *
 *  this pass intends to replace "call" with "tail" inst
 *  1. push up all ret. if a exitBlock has two or more prevs, remove exitBlock and copy its code to every jmp
 *     (so that this optimization must be executed after "exitBlock" is not used any more)
 *
 *  2. make a call tail. remove the "call", and replace the ret with tail inst
 */

public class TCO implements AsmFuncPass {

    private boolean checkSimpleRetBlock(AsmBlock retBlock, AsmFunction function) {
        if (!(retBlock.terminator() instanceof AsmRetInst)) return false;
        for (AsmBlock block : function.blocks)
            for (AsmBaseInst inst : block.instructions)
                if (inst instanceof AsmBrInst && ((AsmBrInst) inst).dest == retBlock) return false;
        return true;
    }

    @Override
    public void runOnFunc(AsmFunction function) {
        Log.track("TCO", function.identifier);

        Queue<AsmBlock> exitQueue = new LinkedList<>();
        exitQueue.offer(function.exitBlock);

        // propagation many times
        int depthLimit = 25;

        for (int i = 1; i <= depthLimit; i++) {
            for (AsmBlock block : function.blocks) {
                if (block.terminator() instanceof AsmJmpInst) {
                    assert !exitQueue.contains(block);
                    var dest =  ((AsmJmpInst) block.terminator()).dest;
                    if (exitQueue.contains(dest)) {
                        block.instructions.removeLast();
                        for (AsmBaseInst inst : dest.instructions) {
                            var copy = inst.copy();
                            block.addInst(copy);
                            // copy can not be jmp
                            if (copy instanceof AsmBrInst && !block.nexts.contains(((AsmBrInst) copy).dest)) {
                                block.nexts.add(((AsmBrInst) copy).dest);
                                ((AsmBrInst) copy).dest.prevs.add(block);
                            }
                        }
                        // Log.info("pust up", block.identifier, dest.identifier);
                        dest.prevs.remove(block);
                        block.nexts.remove(dest);
                    }
                }
            }

            for (AsmBlock exit : exitQueue)
                if (exit.prevs.isEmpty() && exit != function.entryBlock) function.blocks.remove(exit);

            exitQueue.clear();
            for (AsmBlock block : function.blocks) {
                if (checkSimpleRetBlock(block, function)) exitQueue.offer(block);
            }
        }

        for (AsmBlock block : function.blocks) {
            var it = block.instructions.listIterator();

            while (it.hasNext()) {
                var inst = it.next();
                // special judge: terminator must be ret
                if (inst instanceof AsmCallInst && ((AsmCallInst) inst).isTailCall && block.terminator() instanceof AsmRetInst) {
                    // Log.info("tail construct");
                    it.remove();
                    assert block.terminator() instanceof AsmRetInst;
                    block.instructions.removeLast();
                    new AsmTailInst(((AsmCallInst) inst).callFunc, block);
                    break;
                }
            }
        }
    }
}
