package masterball.compiler.middleend.llvmir.type;

public class ArrayType extends BaseType {
    public BaseType elementType;
    public int length;

    public ArrayType(BaseType elementType, int length) {
        this.elementType = elementType;
        this.length = length;
    }

    @Override
    public boolean match(BaseType other) {
        return false;
    }

    @Override
    public int size() {
        return elementType.size() * length;
    }

    @Override
    public String toString() {
        // Array Type grammar
        return "[ " + length + " x " + elementType + " ]";
    }
}
