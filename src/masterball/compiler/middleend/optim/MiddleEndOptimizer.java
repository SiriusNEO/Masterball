package masterball.compiler.middleend.optim;

import masterball.compiler.middleend.analyzer.CallAnalyzer;
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

    @Override
    public void runOnModule(IRModule module) {

        new CallAnalyzer().runOnModule(module);

        for (IRFunction function : module.functions) {
            new CFGBuilder().runOnFunc(function);
            new Glo2Loc().runOnFunc(function);

            new Mem2Reg().runOnFunc(function);

            //TODO

            new SCCP().runOnFunc(function);
            new ADCE().runOnFunc(function);
            new CFGSimplifier().runOnFunc(function);
            new SSADestructor().runOnFunc(function);
        }
    }
}
