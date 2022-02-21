package masterball.compiler.middleend.optim;

import masterball.compiler.middleend.analyzer.LoopAnalyzer;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.share.pass.IRFuncPass;

/**
 *  Loop Invariant Code Motion
 */

public class LICM implements IRFuncPass {
    @Override
    public void runOnFunc(IRFunction function) {
        new LoopAnalyzer().runOnFunc(function);
    }
}
