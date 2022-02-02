package masterball.compiler.backend.regalloc;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.inst.AsmBaseInst;
import masterball.compiler.backend.rvasm.operand.Register;
import masterball.compiler.share.pass.AsmFuncPass;
import masterball.debug.LivenessPrinter;

import java.util.*;

public class LivenessAnalyzer implements AsmFuncPass {

    private final Map<AsmBlock, HashSet<Register>> blockUsesMap = new HashMap<>(),
                                             blockDefsMap = new HashMap<>();

    private final Queue<AsmBlock> workQueue = new LinkedList<>();
    private final HashSet<AsmBlock> finishSet = new HashSet<>();

    @Override
    public void runOnFunc(AsmFunction function) {
        function.blocks.forEach(this::collectUsesAndDefs);
        function.blocks.forEach(this::initLiveness);

        workQueue.offer(function.exitBlock());
        while (!workQueue.isEmpty()) livenessAnalyze(workQueue.poll());
    }

    // first collect all uses and defs in a block
    private void collectUsesAndDefs(AsmBlock block) {
        HashSet<Register> blockUses = new HashSet<>(), blockDefs = new HashSet<>();
        for (AsmBaseInst inst : block.instructions) {
            HashSet<Register> usesInInst = inst.uses();
            usesInInst.removeAll(blockDefs);
            blockUses.addAll(usesInInst);
            blockDefs.addAll(inst.defs());
        }
        blockUsesMap.put(block, blockUses);
        blockDefsMap.put(block, blockDefs);
    }

    private void initLiveness(AsmBlock block) {
        block.liveIn.clear();
        block.liveOut.clear();
    }

    private void livenessAnalyze(AsmBlock block) {
        // data flow equation (reference: Tigerbook):
        // in[n] = use[n] \cup (out[n] - def[n])
        // out[n] = \cap_{s \in suc[n]} in[s]

        if (finishSet.contains(block)) return;
        finishSet.add(block);

        HashSet<Register> newLiveOut = new HashSet<>();
        block.nexts.forEach(suc -> newLiveOut.addAll(suc.liveIn));
        HashSet<Register> newLiveIn = new HashSet<>(newLiveOut);
        newLiveIn.removeAll(blockDefsMap.get(block));
        newLiveIn.addAll(blockUsesMap.get(block));

        if (!newLiveIn.equals(block.liveIn) || !newLiveOut.equals(block.liveOut)) {
            block.liveIn.addAll(newLiveIn);
            block.liveOut.addAll(newLiveOut);
            finishSet.removeAll(block.prevs);
        }

        // BFS
        workQueue.addAll(block.prevs);
    }
}
