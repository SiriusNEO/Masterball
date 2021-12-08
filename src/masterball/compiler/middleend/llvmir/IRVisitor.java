package masterball.compiler.middleend.llvmir;

import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;

public interface IRVisitor {
    void visit(IRModule module);
    void visit(IRFunction function);
    void visit(IRBlock block);
}
