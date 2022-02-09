package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.type.BoolType;
import masterball.compiler.share.lang.LLVM;
import masterball.compiler.share.pass.InstVisitor;

public class IRICmpInst extends IRBaseInst {
    public String op;

    public IRICmpInst(String op, Value lhs, Value rhs, IRBlock parentBlock) {
        super(LLVM.ICmpInst, new BoolType(), parentBlock);
        this.op = op;
        this.addOperand(lhs);
        this.addOperand(rhs);
    }

    public Value lhs() {return this.getOperand(0);}
    public Value rhs() {return this.getOperand(1);}

    public boolean forBr() {return this.users.size() == 1 && this.users.get(0) instanceof IRBrInst;}

    @Override
    public String format() {
        // %icmp = icmp slt i32 %i_value, 4
        return this.identifier() + " = " + LLVM.ICmpInst + " " +
                this.op + " " + this.lhs().typedIdentifier()+ ", " + this.rhs().identifier();
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
