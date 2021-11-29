package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.BasicBlock;
import masterball.compiler.middleend.llvmir.hierarchy.BaseValue;
import masterball.compiler.utils.LLVMTable;

public class StoreInst extends BaseInst {
    public StoreInst(BaseValue destPtr, BaseValue storeValue, BasicBlock parentBlock) {
        super(LLVMTable.StoreInst, storeValue.type, parentBlock);
        this.addOperand(storeValue);
        this.addOperand(destPtr);
    }

    public BaseValue storeValue() {return this.getOperand(0);}
    public BaseValue destPtr() {return this.getOperand(1);}
}
