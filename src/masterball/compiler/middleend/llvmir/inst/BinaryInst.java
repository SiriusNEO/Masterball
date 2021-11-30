package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.BasicBlock;
import masterball.compiler.middleend.llvmir.hierarchy.BaseValue;
import masterball.compiler.middleend.llvmir.type.IntType;

public class BinaryInst extends BaseInst {
    public String op;

    public BinaryInst(String op, BaseValue lhs, BaseValue rhs, BasicBlock parentBlock) {
        super(op, new IntType(), parentBlock);
        this.op = op;
        this.addOperand(lhs);
        this.addOperand(rhs);
    }

    public BaseValue lhs() {return this.getOperand(0);}
    public BaseValue rhs() {return this.getOperand(1);}
}