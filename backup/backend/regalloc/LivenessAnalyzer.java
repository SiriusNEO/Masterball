package masterball.compiler.backend.regalloc;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.inst.AsmBaseInst;
import masterball.compiler.backend.rvasm.operand.Register;
import masterball.compiler.share.pass.AsmFuncPass;
import masterball.debug.LivenessPrinter;

import java.util.*;

public class LivenessAnalyzer implements AsmFuncPass {

    private Map<AsmBlock, HashSet<Register>> uses = new HashMap<>(),
                                             defs = new HashMap<>(),
                                             liveIn = new HashMap<>(),
                                             liveOut = new HashMap<>();

    private LinkedList<AsmBlock> workList = new LinkedList<>();
    private HashSet<AsmBlock> finishSet = new HashSet<>();

    @Override
    public void runOnFunc(AsmFunction function) {
        function.blocks.forEach(this::collectUsesAndDefs);
        function.blocks.forEach(this::initLiveness);
        workList.push(function.exitBlock());
        while (!workList.isEmpty()) livenessAnalyze(workList.poll());
        new LivenessPrinter(uses, defs, liveIn, liveOut).print();
    }

    public HashSet<Register> getLiveOut(AsmBlock block) {
        return liveOut.get(block);
    }

    // first collect all uses and defs in a block
    private void collectUsesAndDefs(AsmBlock block) {
        HashSet<Register> usesInBlock = new HashSet<>(), defsInBlock = new HashSet<>();
        for (AsmBaseInst inst : block.instructions) {
            defsInBlock.addAll(inst.defs);
            inst.uses.forEach(useReg -> {if (!defsInBlock.contains(useReg)) usesInBlock.add(useReg);});
        }
        uses.put(block, usesInBlock);
        defs.put(block, defsInBlock);
    }

    private void initLiveness(AsmBlock block) {
        liveIn.put(block, new HashSet<>());
        liveOut.put(block, new HashSet<>());
    }

    private void livenessAnalyze(AsmBlock block) {
        // data flow equation (reference: Tigerbook):
        // in[n] = use[n] \cup (out[n] - def[n])
        // out[n] = \cap_{s \in suc[n]} in[s]
        if (finishSet.contains(block)) return;
        HashSet<Register> newLiveIn = new HashSet<>(liveOut.get(block)), newLiveOut = new HashSet<>();
        newLiveIn.removeAll(defs.get(block));
        newLiveIn.addAll(uses.get(block));
        block.nexts.forEach(suc -> newLiveOut.addAll(liveOut.get(suc)));
        if (!newLiveIn.equals(liveIn.get(block)) || !newLiveOut.equals(liveOut.get(block))) {
            liveIn.get(block).addAll(newLiveIn);
            liveOut.get(block).addAll(newLiveOut);
            finishSet.removeAll(block.prevs);
        }
        workList.addAll(block.prevs);
        finishSet.add(block);
    }
}
