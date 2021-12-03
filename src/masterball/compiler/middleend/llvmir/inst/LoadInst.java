package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.BasicBlock;
import masterball.compiler.middleend.llvmir.hierarchy.BaseValue;
import masterball.compiler.middleend.llvmir.type.PointerType;
import masterball.compiler.utils.LLVMTable;

public class LoadInst extends BaseInst {
    public LoadInst(BaseValue destPtr, BasicBlock parentBlock) {
        super(resolveRename(destPtr.name),
              ((PointerType) destPtr.type).pointedType,
              parentBlock);
        this.addOperand(destPtr);
    }

    public BaseValue destPtr() {
        return this.getOperand(0);
    }

    @Override
    public String format() {
        // %load = load <type>, <type*> %destPtr, align <size>
        return this.identifier() + " = " + LLVMTable.LoadInst + " " + this.type + ", " +
                this.destPtr().typedIdentifier() + ", align " + this.type.size();
    }
}
