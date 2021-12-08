package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.Value;
import masterball.compiler.middleend.llvmir.type.BoolType;
import masterball.compiler.share.LLVMTable;

public class IRICmpInst extends IRBaseInst {
    public String op;

    public IRICmpInst(String op, Value lhs, Value rhs, IRBlock parentBlock) {
        super(LLVMTable.ICmpInst, new BoolType(), parentBlock);
        this.op = op;
        this.addOperand(lhs);
        this.addOperand(rhs);
    }

    public Value lhs() {return this.getOperand(0);}
    public Value rhs() {return this.getOperand(1);}

    @Override
    public String format() {
        // %icmp = icmp slt i32 %i_value, 4
        return this.identifier() + " = " + LLVMTable.ICmpInst + " " +
                this.op + " " + this.lhs().typedIdentifier()+ ", " + this.rhs().identifier();
    }
}
