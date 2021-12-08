package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.constant.NullptrConst;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.Value;
import masterball.compiler.middleend.llvmir.type.PointerType;
import masterball.compiler.share.LLVMTable;

public class IRStoreInst extends IRBaseInst {
    public IRStoreInst(Value destPtr, Value storeValue, IRBlock parentBlock) {
        super(LLVMTable.StoreInst, storeValue.type, parentBlock);
        this.addOperand(storeValue);
        this.addOperand(destPtr);
    }

    public Value storeValue() {return this.getOperand(0);}
    public Value destPtr() {return this.getOperand(1);}

    @Override
    public String format() {
        // store i32 %1, i32* %i, align 4
        // nullptr has the same type with destPtr.pointedType
        if (this.storeValue() instanceof NullptrConst) {
            return LLVMTable.StoreInst + " " + ((PointerType) this.destPtr().type).pointedType + " " +
                    this.storeValue().identifier() + ", " + this.destPtr().typedIdentifier() + ", align " + this.type.size();
        }

        return LLVMTable.StoreInst + " " + this.storeValue().typedIdentifier() + ", " + this.destPtr().typedIdentifier() + ", align " + this.type.size();
    }
}
