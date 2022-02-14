package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.share.pass.InstVisitor;

public class IRBinaryInst extends IRBaseInst {
    public String op;

    public IRBinaryInst(String op, IRBaseType retType, Value lhs, Value rhs, IRBlock parentBlock) {
        super(op, retType, parentBlock);
        this.op = op;
        this.addOperand(lhs);
        this.addOperand(rhs);
    }

    public Value lhs() {return this.getOperand(0);}
    public Value rhs() {return this.getOperand(1);}

    @Override
    public String format() {
        // %add = add i32 %A, %B
        return this.identifier() + " = " + this.op + " " + this.type + " " +
                this.lhs().identifier() + ", " + this.rhs().identifier();
    }

    @Override
    public IRBaseInst copy() {
        return new IRBinaryInst(op, type, lhs(), rhs(), null);
    }

    @Override
    public void accept(InstVisitor visitor) {
        visitor.visit(this);
    }
}
