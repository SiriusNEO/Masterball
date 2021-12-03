package masterball.compiler.middleend.llvmir.type;

// ArrayType in LLVM IR
// only use it to implement string
// Array in MxStar is compiled to Pointer.

public class ArrayType extends IRBaseType {
    public IRBaseType elementType;
    public int length;

    public ArrayType(IRBaseType elementType, int length) {
        this.elementType = elementType;
        this.length = length;
    }

    @Override
    public boolean match(IRBaseType other) {
        return false;
    }

    // align size
    @Override
    public int size() {
        return elementType.size();
    }

    @Override
    public String toString() {
        return "[" + length + " x " + elementType + "]";
    }
}
