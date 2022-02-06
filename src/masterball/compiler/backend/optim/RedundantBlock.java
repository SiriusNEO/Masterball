package masterball.compiler.backend.optim;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.inst.AsmBaseInst;
import masterball.compiler.backend.rvasm.inst.AsmBrInst;
import masterball.compiler.backend.rvasm.inst.AsmJmpInst;
import masterball.compiler.share.pass.AsmFuncPass;

import java.util.HashMap;
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

    @Override
    public void runOnFunc(AsmFunction function) {

        for (AsmBlock block : function.blocks) {
            if (block.instructions.size() == 1 && block.instructions.get(0) instanceof AsmJmpInst) {
                var replace = getAlias(((AsmJmpInst) block.instructions.get(0)).dest);
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
                it.remove();

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
