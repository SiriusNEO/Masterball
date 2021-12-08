package masterball.compiler.middleend.pass;

import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;

public abstract class IRFuncPass extends Pass {

    public abstract void pass(IRFunction function);

}
