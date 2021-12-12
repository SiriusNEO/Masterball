package masterball.compiler.share.pass;

import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;

public interface IRFuncPass extends Pass {
    void runOnFunc(IRFunction function);
}
