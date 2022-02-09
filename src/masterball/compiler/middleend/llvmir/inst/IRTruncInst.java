package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.share.lang.LLVM;
import masterball.compiler.share.pass.InstVisitor;

public class IRTruncInst extends IRBaseInst {

    public IRTruncInst(Value fromValue, IRBaseType targetType, IRBlock parentBlock) {
        super(LLVM.TruncInst, targetType, parentBlock);
        this.addOperand(fromValue);
    }

    public Value fromValue() {return this.getOperand(0);}

    @Override
    public String format() {
        // %trunc = trunc i32 %a to i8;
        return this.identifier() + " = " + LLVM.TruncInst + " " + this.fromValue().typedIdentifier()
                + " to " + this.type;
    }

    @Override
    public IRBaseInst copy() {
        return null;
    }

    @Override
    public void accept(InstVisitor visitor) {
        visitor.visit(this);
    }
}
