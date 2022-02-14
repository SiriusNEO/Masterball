package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.type.VoidType;
import masterball.compiler.share.lang.LLVM;
import masterball.compiler.share.pass.InstVisitor;

public class IRRetInst extends IRBaseInst {

    public IRRetInst(IRBlock parentBlock) {
        super(LLVM.RetInst, new VoidType(), parentBlock);
    }

    public IRRetInst(Value retVal, IRBlock parentBlock) {
        super(LLVM.RetInst, retVal.type, parentBlock);
        this.addOperand(retVal);
    }

    public Value retVal() {
        return this.getOperand(0);
    }

    public boolean isVoid() {return this.operandSize() == 0;}

    @Override
    public boolean mayHaveSideEffects() {return true;}

    @Override
    public boolean isTerminator() {return true;}

    @Override
    public IRBaseInst copy() {
        if (isVoid()) return new IRRetInst(null);
        return new IRRetInst(retVal(), null);
    }

    @Override
    public String format() {
        // ret i32 0
        // ret void
        String ret = LLVM.RetInst + " " + this.type;
        if (!this.type.match(new VoidType()))
            ret += " " + this.retVal().identifier();
        return ret;
    }

    @Override
    public void accept(InstVisitor visitor) {
        visitor.visit(this);
    }
}
