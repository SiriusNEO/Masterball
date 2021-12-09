package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.Value;
import masterball.compiler.middleend.llvmir.type.VoidType;
import masterball.compiler.share.LLVMTable;

public class IRBrInst extends IRBaseInst {
    public IRBrInst(IRBlock destBlock, IRBlock parentBlock) {
        super(LLVMTable.BrInst, new VoidType(), parentBlock);
        this.addOperand(destBlock);
        this.parentBlock.linkParentBlock(this);
    }

    public IRBrInst(Value condition, IRBlock ifTrueBlock, IRBlock ifFalseBlock, IRBlock parentBlock) {
        super(LLVMTable.BrInst, new VoidType(), parentBlock);
        this.addOperand(condition);
        this.addOperand(ifTrueBlock);
        this.addOperand(ifFalseBlock);
        this.parentBlock.linkParentBlock(this);
    }

    public boolean isJump() {
        return this.operandSize() == 1;
    }

    public IRBlock destBlock() {
        return (IRBlock) this.getOperand(0);
    }
    public Value condition() {
        return this.getOperand(0);
    }
    public IRBlock ifTrueBlock() {
        return (IRBlock) this.getOperand(1);
    }
    public IRBlock ifFalseBlock() {
        return (IRBlock) this.getOperand(2);
    }

    public void resetDestBlock(IRBlock newBlock) {this.resetOperand(0, newBlock);}
    public void resetIfTrueBlock(IRBlock newBlock) {this.resetOperand(1, newBlock);}
    public void resetIfFalseBlock(IRBlock newBlock) {this.resetOperand(2, newBlock);}

    @Override
    public boolean isTerminator() {return true;}

    @Override
    public String format() {
        // br i1 %comparison_result, label %A, label %B
        // br label %A
        if (!this.isJump()) {
            return LLVMTable.BrInst + " " + this.condition().type + " " + this.condition().identifier()
                    + ", " + this.ifTrueBlock().typedIdentifier()
                    + ", " + this.ifFalseBlock().typedIdentifier();
        }
        else {
            return LLVMTable.BrInst + " " + this.destBlock().typedIdentifier();
        }
    }
}