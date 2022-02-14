package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.share.lang.LLVM;
import masterball.compiler.share.pass.InstVisitor;

public class IRBitCastInst extends IRBaseInst {
    public IRBitCastInst(Value fromValue, IRBaseType targetType, IRBlock parentBlock) {
        super(LLVM.BitCastInst, targetType, parentBlock);
        this.addOperand(fromValue);
    }

    public Value fromValue() {return this.getOperand(0);}

    @Override
    public String format() {
        // %bitcast = bitcast i8** %a to i8*;
        return this.identifier() + " = " + LLVM.BitCastInst + " " + this.fromValue().typedIdentifier()
                + " to " + this.type;
    }

    @Override
    public IRBaseInst copy() {
        return new IRBitCastInst(fromValue(), type, null);
    }

    @Override
    public void accept(InstVisitor visitor) {
        visitor.visit(this);
    }
}
