package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.User;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.share.pass.InstVisitor;

public abstract class IRBaseInst extends User {
    public IRBlock parentBlock;
    public String instName;

    public IRBaseInst(String name, IRBaseType type, IRBlock parentBlock) {
        super(name, type);
        setParentBlock(parentBlock);
    }

    public IRBaseInst(String name, IRBaseType type, IRBlock parentBlock, boolean frontInsert) {
        super(name, type);
        this.instName = name; // instName is the same with value name before rename
        setParentBlockAtHead(parentBlock);
    }

    public void setParentBlock(IRBlock parentBlock) {
        this.parentBlock = parentBlock;
        if (parentBlock != null) parentBlock.addInst(this);
    }

    public void setParentBlockAtHead(IRBlock parentBlock) {
        this.parentBlock = parentBlock;
        if (parentBlock != null) parentBlock.instructions.addFirst(this);
    }

    public void removedFromUser() {
        for (Value value : operands) {
            if (value != null)
                value.users.remove(this);
        }
    }

    public boolean mayHaveSideEffects() {return false;}

    public abstract String format();

    public boolean isTerminator() {return false;}

    public abstract IRBaseInst copy();

    public abstract void accept(InstVisitor visitor);
}
