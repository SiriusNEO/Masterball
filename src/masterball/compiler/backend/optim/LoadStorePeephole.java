package masterball.compiler.backend.optim;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.inst.AsmBaseInst;
import masterball.compiler.backend.rvasm.inst.AsmLoadInst;
import masterball.compiler.backend.rvasm.inst.AsmStoreInst;
import masterball.compiler.share.pass.AsmFuncPass;

import java.util.HashSet;

/**
 *  This Peephole optimization intends to remove codes like:
 *      sw  t0, addr
 *      lw  t0, addr
 *   useless: because Mem2Reg has removed them
 */

public class LoadStorePeephole implements AsmFuncPass {

    @Override
    public void runOnFunc(AsmFunction function) {
        for (AsmBlock block : function.blocks) {
            HashSet<AsmBaseInst> removeSet = new HashSet<>();

            for (int i = 0; i < block.instructions.size() - 1; ++i) {
                if (block.instructions.get(i) instanceof AsmStoreInst && block.instructions.get(i+1) instanceof AsmLoadInst) {
                    AsmStoreInst store = (AsmStoreInst) block.instructions.get(i);
                    AsmLoadInst load = (AsmLoadInst) block.instructions.get(i+1);

                    if (store.imm.value == load.imm.value && store.rs2.color == load.rd.color && store.rs1.color == load.rs1.color) {
                        removeSet.add(store);
                        removeSet.add(load);
                    }
                }
            }
            removeSet.forEach(inst -> block.instructions.remove(inst));
        }
    }
}
