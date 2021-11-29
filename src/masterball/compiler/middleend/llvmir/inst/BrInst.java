package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.BasicBlock;
import masterball.compiler.middleend.llvmir.hierarchy.BaseValue;
import masterball.compiler.middleend.llvmir.type.VoidType;
import masterball.compiler.utils.LLVMTable;

public class BrInst extends BaseInst {
    public BrInst(BaseValue condition, BasicBlock ifTrueBlock, BasicBlock ifFalseBlock, BasicBlock parentBlock) {
        super(LLVMTable.BrInst, new VoidType(), parentBlock);
        this.addOperand(condition);
        this.addOperand(ifTrueBlock);
        this.addOperand(ifFalseBlock);
    }

    public BaseValue condition() {
        return this.getOperand(0);
    }

    public BasicBlock ifTrueBlock() {
        return (BasicBlock) this.getOperand(1);
    }

    public BasicBlock ifFalseBlock() {
        return (BasicBlock) this.getOperand(2);
    }
}
