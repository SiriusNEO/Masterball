package masterball.compiler.middleend.optim;

import masterball.compiler.middleend.analyzer.CallGraphAnalyzer;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;
import masterball.compiler.middleend.analyzer.CFGBuilder;
import masterball.compiler.middleend.optim.ssa.Mem2Reg;
import masterball.compiler.middleend.optim.ssa.SSADestructor;
import masterball.compiler.share.pass.IRModulePass;
import masterball.debug.Log;


// Mem2Reg eliminates allocate
// SSADestructor is necessary to eliminate phi
// CFGSimplifier (merge block) must be ahead of SSADestructor for the correct insertion of move

public class MiddleEndOptimizer implements IRModulePass {

    private static final int OptimizeRound = 5;

    @Override
    public void runOnModule(IRModule module) {

        new CallGraphAnalyzer().runOnModule(module);

        for (IRFunction function : module.functions) {
            new Glo2Loc().runOnFunc(function);
            new Mem2Reg().runOnFunc(function);
        }

        boolean forceInlined = false;
        for (int i = 1; i <= OptimizeRound; i++) {
            new FuncInliner(false).runOnModule(module);

            for (IRFunction function : module.functions) {
                new SCCP().runOnFunc(function);
                new ADCE().runOnFunc(function);
                new CFGSimplifier().runOnFunc(function);
                new CSE().runOnFunc(function);
            }

            if (!forceInlined) {
                new FuncInliner(true).runOnModule(module);
                forceInlined = true;
            }
        }

        for (IRFunction function : module.functions)
            new SSADestructor().runOnFunc(function);

        for (IRFunction function : module.functions) new CFGBuilder().runOnFunc(function);
    }
}
