package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.BasicBlock;
import masterball.compiler.middleend.llvmir.type.BaseType;

public class GetElementPtrInst extends BaseInst {
    public GetElementPtrInst(String name, BaseType type, BasicBlock parentBlock) {
        super(name, type, parentBlock);
    }
}
