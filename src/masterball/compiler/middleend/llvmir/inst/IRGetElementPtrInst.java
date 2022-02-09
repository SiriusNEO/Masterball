package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.middleend.llvmir.type.PointerType;
import masterball.compiler.middleend.llvmir.type.StructType;
import masterball.compiler.share.error.runtime.UnknownError;
import masterball.compiler.share.lang.LLVM;
import masterball.compiler.share.pass.InstVisitor;

public class IRGetElementPtrInst extends IRBaseInst {

    // headPointer is the field (struct* or a pointer)
    // yieldType / retType is the type of the result
    // hint: move ptr: getelement type, type* ptr %a, i32 offset

    public IRGetElementPtrInst(String elementName, Value headPointer, IRBaseType yieldType , IRBlock parentBlock, Value... indices) {
        super(addrRename(elementName), yieldType, parentBlock);
        assert headPointer.type instanceof PointerType;
        this.addOperand(headPointer);
        for (Value index : indices) this.addOperand(index);
    }

    public IRGetElementPtrInst(Value headPointer, IRBaseType yieldType , IRBlock parentBlock, Value... indices) {
        super(LLVM.GetElementPtrInst, yieldType, parentBlock);
        assert headPointer.type instanceof PointerType;
        this.addOperand(headPointer);
        for (Value index : indices) this.addOperand(index);
    }

    public int indicesNum() {return this.operandSize() - 1;}

    public Value getIndex(int pos) {
        return this.getOperand(pos+1);
    }

    public Value headPointer() {
        return this.getOperand(0);
    }

    public boolean isGetMember() {
        if (indicesNum() > 2) throw new UnknownError(this); // it is highly special...
        return ((PointerType) headPointer().type).pointedType instanceof StructType && indicesNum() == 2;
    }

    public Value ptrMoveIndex() { return this.getIndex(0); }

    public Value memberIndex() {return this.getIndex(1);}

    @Override
    public String format() {
        // %t4 = getelementptr [10 x [20 x i32]], [10 x [20 x i32]]* %t3, i32 0, i32 5
        StringBuilder ret = new StringBuilder(this.identifier() + " = " + LLVM.GetElementPtrInst
                + " inbounds " + ((PointerType) this.headPointer().type).pointedType
                + ", " + this.headPointer().typedIdentifier());
        for (int i = 0; i < this.indicesNum(); ++i)
            ret.append(", ").append(this.getIndex(i).typedIdentifier());
        return ret.toString();
    }

    @Override
    public IRBaseInst copy() {
        return null;
    }

    @Override
    public void accept(InstVisitor visitor) {
        visitor.visit(this);
    }
}
