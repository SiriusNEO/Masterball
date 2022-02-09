package masterball.compiler.backend.analyzer;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.inst.AsmBaseInst;
import masterball.compiler.backend.rvasm.operand.Register;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.share.pass.AsmFuncPass;
import masterball.debug.Log;

import java.util.*;

/**
 * Liveness Analyzer Pass run on Assembly
 *
 * data flow equation:
 *      liveIn[n] = use[n] \cup (out[n] - def[n])
 *      liveOut[n] = \cap_{s \in suc[n]} in[s]
 *
 * @reference: Tiger Book
 */

public class LivenessAnalyzer implements AsmFuncPass {

    private final Queue<AsmBlock> workQueue = new LinkedList<>();
    private final HashSet<AsmBlock> finishSet = new HashSet<>();

    @Override
    public void runOnFunc(AsmFunction function) {
        init(function);
        function.blocks.forEach(this::collectUsesAndDefs);

        // Log.report(function.identifier);
        // Log.report(function.exitBlock);

        workQueue.offer(function.exitBlock);
        while (!workQueue.isEmpty()) livenessAnalyze(workQueue.poll());
    }

    private void init(AsmFunction function) {
        for (AsmBlock block : function.blocks) {
            block.liveIn.clear();
            block.liveOut.clear();
        }
    }

    private final Map<AsmBlock, HashSet<Register>> blockUsesMap = new HashMap<>(),
                                                blockDefsMap = new HashMap<>();

    // first collect all uses and defs in a block
    private void collectUsesAndDefs(AsmBlock block) {
        HashSet<Register> blockUses = new HashSet<>(), blockDefs = new HashSet<>();
        for (AsmBaseInst inst : block.instructions) {
            inst.uses().forEach(use -> {
                if (!blockDefs.contains(use)) blockUses.add(use);
            });
            blockDefs.addAll(inst.defs());
        }
        blockUsesMap.put(block, blockUses);
        blockDefsMap.put(block, blockDefs);
    }

    private void livenessAnalyze(AsmBlock block) {

        if (finishSet.contains(block)) return;
        finishSet.add(block);

        // out = suc in
        HashSet<Register> newLiveOut = new HashSet<>();
        block.nexts.forEach(suc -> newLiveOut.addAll(suc.liveIn));

        // in = use & (out - def)
        HashSet<Register> newLiveIn = new HashSet<>(newLiveOut);
        newLiveIn.removeAll(blockDefsMap.get(block));
        newLiveIn.addAll(blockUsesMap.get(block));

        // fixed point
        if (!newLiveIn.equals(block.liveIn) || !newLiveOut.equals(block.liveOut)) {
            block.liveIn.addAll(newLiveIn);
            block.liveOut.addAll(newLiveOut);
            block.prevs.forEach(finishSet::remove);
        }

        // BFS
        workQueue.addAll(block.prevs);
    }
}
