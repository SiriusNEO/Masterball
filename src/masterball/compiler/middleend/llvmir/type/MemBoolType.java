package masterball.compiler.middleend.llvmir.type;

public class MemBoolType extends IRBaseType {
    @Override
    public boolean match(IRBaseType other) {
        return other instanceof MemBoolType;
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public String toString() {
        return "i8";
    }
}
