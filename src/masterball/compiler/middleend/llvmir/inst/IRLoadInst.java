package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.Value;
import masterball.compiler.middleend.llvmir.type.PointerType;
import masterball.compiler.share.LLVMTable;

public class IRLoadInst extends IRBaseInst {
    public IRLoadInst(Value destPtr, IRBlock parentBlock) {
        super(resolveRename(destPtr.name),
              ((PointerType) destPtr.type).pointedType,
              parentBlock);
        this.addOperand(destPtr);
    }

    public Value destPtr() {
        return this.getOperand(0);
    }

    @Override
    public String format() {
        // %load = load <type>, <type*> %destPtr, align <size>
        return this.identifier() + " = " + LLVMTable.LoadInst + " " + this.type + ", " +
                this.destPtr().typedIdentifier() + ", align " + this.type.size();
    }
}
