package masterball.compiler.share.pass;

import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;

public interface IRModulePass extends Pass {
    void runOnModule(IRModule module);
}
