package masterball.compiler.middleend.optim;

import masterball.compiler.middleend.analyzer.CallGraphAnalyzer;
import masterball.compiler.middleend.analyzer.LoopAnalyzer;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;
import masterball.compiler.middleend.optim.ssa.Mem2Reg;
import masterball.compiler.middleend.optim.ssa.SSADestructor;
import masterball.compiler.share.pass.IRModulePass;


// Mem2Reg eliminates allocate
// SSADestructor is necessary to eliminate phi
// CFGSimplifier (merge block) must be ahead of SSADestructor for the correct insertion of move

public class MiddleEndOptimizer implements IRModulePass {

    @Override
    public void runOnModule(IRModule module) {

        new CallGraphAnalyzer().runOnModule(module);

        for (IRFunction function : module.functions) {
            new Glo2Loc().runOnFunc(function);
            new Mem2Reg().runOnFunc(function);
        }

        for (int i = 1; i <= 5; i++) {
            new FuncInliner(false).runOnModule(module);

            for (IRFunction function : module.functions) {
                new GVN().runOnFunc(function);
                new SCCP().runOnFunc(function);
                new ADCE().runOnFunc(function);
                new CFGSimplifier().runOnFunc(function);
                new IVTrans().runOnFunc(function);
                new LICM().runOnFunc(function);
                new LocalMO().runOnFunc(function);
            }
        }

        new FuncInliner(true).runOnModule(module);

        // re-analyze info for asm
        for (IRFunction function : module.functions) {
            new SSADestructor().runOnFunc(function);
            new CFGSimplifier().runOnFunc(function);
            new LocalMO().runOnFunc(function);
            new TRO().runOnFunc(function);
            new LoopAnalyzer().runOnFunc(function);
        }
    }
}