package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.constant.NullptrConst;
import masterball.compiler.middleend.llvmir.hierarchy.BasicBlock;
import masterball.compiler.middleend.llvmir.hierarchy.BaseValue;
import masterball.compiler.middleend.llvmir.type.ArrayType;
import masterball.compiler.middleend.llvmir.type.PointerType;
import masterball.compiler.utils.LLVMTable;

public class StoreInst extends BaseInst {
    public StoreInst(BaseValue destPtr, BaseValue storeValue, BasicBlock parentBlock) {
        super(LLVMTable.StoreInst, storeValue.type, parentBlock);
        this.addOperand(storeValue);
        this.addOperand(destPtr);
    }

    public BaseValue storeValue() {return this.getOperand(0);}
    public BaseValue destPtr() {return this.getOperand(1);}

    @Override
    public String format() {
        // store i32 %1, i32* %i
        // nullptr has the same type with destPtr.pointedType
        if (this.storeValue() instanceof NullptrConst) {
            return LLVMTable.StoreInst + " " + ((PointerType) this.destPtr().type).pointedType + " " +
                    this.storeValue().identifier() + ", " + this.destPtr().typedIdentifier();
        }

        return LLVMTable.StoreInst + " " + this.storeValue().typedIdentifier() + ", " + this.destPtr().typedIdentifier();
    }
}
