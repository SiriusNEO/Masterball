package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.BasicBlock;
import masterball.compiler.middleend.llvmir.hierarchy.BaseUser;
import masterball.compiler.middleend.llvmir.type.IRBaseType;

public class BaseInst extends BaseUser {
    public BasicBlock parentBlock;

    public BaseInst(String name, IRBaseType type, BasicBlock parentBlock) {
        super(name, type);
        setParentBlock(parentBlock);
    }

    public void setParentBlock(BasicBlock parentBlock) {
        this.parentBlock = parentBlock;
        if (parentBlock != null) parentBlock.addInst(this);
    }

    public String format() {return "";}

    public boolean isTerminator() {return false;}
}
