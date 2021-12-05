package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.BaseValue;
import masterball.compiler.middleend.llvmir.hierarchy.BasicBlock;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.middleend.llvmir.type.PointerType;
import masterball.compiler.utils.LLVMTable;

public class GetElementPtrInst extends BaseInst {

    // headPointer is the field (struct* or a pointer)
    // yieldType / retType is the type of the result
    // hint: move ptr: getelement type, type* ptr %a, i32 offset

    public GetElementPtrInst(String elementName, BaseValue headPointer, IRBaseType yieldType , BasicBlock parentBlock, BaseValue... indices) {
        super(addrRename(elementName), yieldType, parentBlock);
        this.addOperand(headPointer);
        for (BaseValue index : indices) this.addOperand(index);
    }

    public GetElementPtrInst(BaseValue headPointer, IRBaseType yieldType , BasicBlock parentBlock, BaseValue... indices) {
        super(LLVMTable.GetElementPtrInst, yieldType, parentBlock);
        this.addOperand(headPointer);
        for (BaseValue index : indices) this.addOperand(index);
    }

    public int indicesNum() {return this.operands.size() - 1;}

    public BaseValue getIndex(int pos) {
        return this.getOperand(pos+1);
    }

    public BaseValue headPointer() {
        return this.getOperand(0);
    }

    @Override
    public String format() {
        // %t4 = getelementptr [10 x [20 x i32]], [10 x [20 x i32]]* %t3, i32 0, i32 5
        StringBuilder ret = new StringBuilder(this.identifier() + " = " + LLVMTable.GetElementPtrInst
                + " " + ((PointerType) this.headPointer().type).pointedType
                + ", " + this.headPointer().typedIdentifier());
        for (int i = 0; i < this.indicesNum(); ++i)
            ret.append(", ").append(this.getIndex(i).typedIdentifier());
        return ret.toString();
    }
}
