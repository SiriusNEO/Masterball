package masterball.compiler.middleend.optim;

import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;
import masterball.compiler.middleend.ssa.CFGAnalyzer;
import masterball.compiler.middleend.ssa.Mem2Reg;
import masterball.compiler.middleend.ssa.SSADestructor;
import masterball.compiler.share.pass.IRModulePass;

// SSADestructor is necessary to eliminate phi

public class MiddleEndOptimizer implements IRModulePass {

    @Override
    public void runOnModule(IRModule module) {

        for (IRFunction function : module.functions) {
            new CFGAnalyzer().runOnFunc(function);
            new Mem2Reg().runOnFunc(function);

            //TODO

            new SSADestructor().runOnFunc(function);
        }
    }
}
