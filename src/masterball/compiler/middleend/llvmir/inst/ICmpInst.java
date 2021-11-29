package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.BasicBlock;
import masterball.compiler.middleend.llvmir.hierarchy.BaseValue;
import masterball.compiler.middleend.llvmir.type.BoolType;
import masterball.compiler.utils.LLVMTable;

public class ICmpInst extends BaseInst {
    public String op;

    public ICmpInst(String op, BaseValue lhs, BaseValue rhs, BasicBlock parentBlock) {
        super(op, new BoolType(), parentBlock);
        this.op = op;
        this.addOperand(lhs);
        this.addOperand(rhs);
    }

    public BaseValue lhs() {return this.getOperand(0);}
    public BaseValue rhs() {return this.getOperand(1);}
}
