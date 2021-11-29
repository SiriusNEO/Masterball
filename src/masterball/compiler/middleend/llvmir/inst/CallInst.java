package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.BasicBlock;
import masterball.compiler.middleend.llvmir.type.BaseType;

public class CallInst extends BaseInst {
    public CallInst(String name, BaseType type, BasicBlock parentBlock) {
        super(name, type, parentBlock);
    }
}
