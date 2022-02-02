package masterball.compiler.middleend.ssa;

import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.share.pass.IRFuncPass;

public class Mem2Reg implements IRFuncPass {
    // TODO: MEM2REG

    @Override
    public void runOnFunc(IRFunction function) {
        new DomTreeBuilder().runOnFunc(function);

    }

    private void phiInsertion(IRFunction function) {

    }
}
