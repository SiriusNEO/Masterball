package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.BaseValue;
import masterball.compiler.middleend.llvmir.hierarchy.BasicBlock;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.utils.LLVMTable;
import masterball.compiler.utils.error.runtime.UnknownError;

// number of PhiInst operands must be even

public class PhiInst extends BaseInst {
    public PhiInst(IRBaseType yieldType, BasicBlock parentBlock, BaseValue... operands) {
        super(LLVMTable.PhiInst, yieldType, parentBlock);

        for (BaseValue operand : operands) this.addOperand(operand);

        if (operands.length % 2 != 0) throw new UnknownError(this);
    }

    public void addBranch(BaseValue branchData, BasicBlock preBlock) {
        this.addOperand(branchData);
        this.addOperand(preBlock);
    }

    @Override
    public String format() {
        // %indvar = phi i32 [ 0, %LoopHeader ], [ %nextindvar, %Loop ]
        String ret = this.identifier() + " = " + LLVMTable.PhiInst + " " + this.type + " ";

        for (int i = 0; i < this.operands.size(); i += 2) {
            ret += "[" + this.getOperand(i).identifier() + ", " + this.getOperand(i+1).identifier() + "]";
            if (i < this.operands.size() - 2) ret += ", ";
        }

        return ret;
    }
}
