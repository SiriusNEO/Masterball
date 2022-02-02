package masterball.compiler.backend.regalloc;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.inst.AsmBaseInst;
import masterball.compiler.backend.rvasm.operand.Register;
import masterball.compiler.share.pass.AsmFuncPass;
import masterball.debug.LivenessPrinter;
import masterball.debug.Log;

import java.util.*;

public class LivenessAnalyzer implements AsmFuncPass {

    private final Map<AsmBlock, HashSet<Register>> uses = new HashMap<>(),
                                             defs = new HashMap<>(),
                                             liveIn = new HashMap<>(),
                                             liveOut = new HashMap<>();

    private final HashSet<AsmBlock> finishSet = new HashSet<>();

    @Override
    public void runOnFunc(AsmFunction function) {
        function.blocks.forEach(this::collectUsesAndDefs);
        function.blocks.forEach(this::initLiveness);

        livenessAnalyze(function.exitBlock());
    }

    public HashSet<Register> getLiveOut(AsmBlock block) {
        return liveOut.get(block);
    }

    // first collect all uses and defs in a block
    private void collectUsesAndDefs(AsmBlock block) {
        HashSet<Register> usesInBlock = new HashSet<>(), defsInBlock = new HashSet<>();
        for (AsmBaseInst inst : block.instructions) {
            HashSet<Register> usesInInst = inst.uses();
            usesInInst.removeAll(defsInBlock);
            usesInBlock.addAll(usesInInst);
            defsInBlock.addAll(inst.defs());
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
        finishSet.add(block);

        HashSet<Register> newLiveOut = new HashSet<>();
        block.nexts.forEach(suc -> newLiveOut.addAll(liveIn.get(suc)));
        HashSet<Register> newLiveIn = new HashSet<>(newLiveOut);
        newLiveIn.removeAll(defs.get(block));
        newLiveIn.addAll(uses.get(block));

        if (newLiveIn.size() != liveIn.get(block).size() || newLiveOut.size() != liveOut.get(block).size()) {
            liveIn.get(block).addAll(newLiveIn);
            liveOut.get(block).addAll(newLiveOut);
            finishSet.removeAll(block.prevs);
        }

        block.prevs.forEach(this::livenessAnalyze);
    }
}
