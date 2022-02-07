package masterball.compiler.backend.optim;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.inst.AsmBaseInst;
import masterball.compiler.backend.rvasm.inst.AsmBrInst;
import masterball.compiler.backend.rvasm.inst.AsmJmpInst;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.share.pass.AsmFuncPass;
import masterball.debug.Log;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * this pass intends to remove block:
 * b1:
 *      j  b2
 * directly use b1 to replace b2
 */

public class RedundantBlock implements AsmFuncPass {

    private final Map<AsmBlock, AsmBlock> aliasMap = new HashMap<>();

    private AsmBlock getAlias(AsmBlock block) {
        if (!aliasMap.containsKey(block)) return block;
        var alias = getAlias(aliasMap.get(block));
        aliasMap.put(block, alias);
        return alias;
    }

    private AsmBlock getOnlyDest(AsmBlock block) {
        HashSet<AsmBlock> dests = new HashSet<>();
        for (AsmBaseInst inst :block.instructions) {
            if (!(inst instanceof AsmBrInst || inst instanceof AsmJmpInst)) return null;
            if (inst instanceof AsmBrInst) dests.add(((AsmBrInst) inst).dest);
            else dests.add(((AsmJmpInst) inst).dest);
        }
        if (dests.size() > 1) return null;
        return dests.iterator().next();
    }

    @Override
    public void runOnFunc(AsmFunction function) {
        boolean changed = true;

        while (changed) {
            changed = false;
            aliasMap.clear();
            // Log.mark("round");

            for (AsmBlock block : function.blocks) {
                var dest = getOnlyDest(block);
                if (dest != null) {
                    // Log.report("remove", block);
                    var replace = getAlias(dest);
                    aliasMap.put(block, replace);
                }
            }

            var it = function.blocks.iterator();

            while (it.hasNext()) {
                var block = it.next();
                if (aliasMap.containsKey(block)) {
                    var alias = getAlias(block);
                    for (AsmBlock pre : block.prevs) {
                        for (AsmBaseInst inst : pre.instructions) {
                            if (inst instanceof AsmBrInst && ((AsmBrInst) inst).dest == block)
                                ((AsmBrInst) inst).dest = alias;
                            if (inst instanceof AsmJmpInst && ((AsmJmpInst) inst).dest == block)
                                ((AsmJmpInst) inst).dest = alias;
                        }
                    }

                    alias.prevs.addAll(block.prevs);
                    // nexts must be the same

                    it.remove();
                    changed = true;

                    // if entry is eliminated, the alias should swap with the first
                    if (block == function.entryBlock) {
                        function.entryBlock = alias;
                        var index = function.blocks.indexOf(alias);
                        function.blocks.set(index, function.blocks.get(0));
                        function.blocks.set(0, alias);
                    }
                }
            }
        }
    }

}
