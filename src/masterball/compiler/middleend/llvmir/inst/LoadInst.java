package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.BasicBlock;
import masterball.compiler.middleend.llvmir.hierarchy.BaseValue;
import masterball.compiler.middleend.llvmir.type.PointerType;
import masterball.compiler.utils.LLVMTable;

public class LoadInst extends BaseInst {
    public LoadInst(BaseValue destPtr, BasicBlock parentBlock) {
        super(destPtr.name.replace(LLVMTable.AddrSuffix, LLVMTable.ResolvedSuffix),
                ((PointerType) destPtr.type).pointed, parentBlock);
        this.addOperand(destPtr);
    }

    public BaseValue destPtr() {
        return this.getOperand(0);
    }
}
