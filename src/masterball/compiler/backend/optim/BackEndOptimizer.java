package masterball.compiler.backend.optim;

import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.hierarchy.AsmModule;
import masterball.compiler.share.pass.AsmModulePass;

public class BackEndOptimizer implements AsmModulePass {
    @Override
    public void runOnModule(AsmModule module) {
        for (AsmFunction function : module.functions) {
            new CoalesceMoves().runOnFunc(function);
            new ArithmPeephole().runOnFunc(function);
            new BlockMerge().runOnFunc(function);
            new ReorderBlock().runOnFunc(function);
        }
    }
}
