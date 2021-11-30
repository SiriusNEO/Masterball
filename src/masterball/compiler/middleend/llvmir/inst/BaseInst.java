package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.BasicBlock;
import masterball.compiler.middleend.llvmir.hierarchy.BaseUser;
import masterball.compiler.middleend.llvmir.type.BaseType;

public class BaseInst extends BaseUser {
    public BasicBlock parentBlock;

    public BaseInst(String name, BaseType type, BasicBlock parentBlock) {
        super(name, type);
        this.parentBlock = parentBlock;
        parentBlock.addInst(this);
    }

    public boolean isTerminator() {return false;}
}
