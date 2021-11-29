package masterball.compiler.middleend.llvmir.type;

public class VoidType extends BaseType {
    @Override
    public boolean match(BaseType other) {
        return other instanceof VoidType;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String toString() {
        return "void";
    }
}
