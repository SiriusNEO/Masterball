package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.BaseValue;
import masterball.compiler.middleend.llvmir.hierarchy.BasicBlock;
import masterball.compiler.middleend.llvmir.type.BaseType;
import masterball.compiler.middleend.llvmir.type.VoidType;
import masterball.compiler.utils.LLVMTable;

public class RetInst extends BaseInst {

    public RetInst(BasicBlock parentBlock) {
        super(LLVMTable.RetInst, new VoidType(), parentBlock);
    }

    public RetInst(BaseValue retVal, BasicBlock parentBlock) {
        super(LLVMTable.RetInst, retVal.type, parentBlock);
        this.addOperand(retVal);
    }

    public BaseValue retVal() {
        return this.getOperand(0);
    }
}
