package masterball.compiler.middleend.llvmir.type;

public class BoolType extends BaseType {
    @Override
    public boolean match(BaseType other) {
        return other instanceof BoolType;
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public String toString() {
        return "i1";
    }
}
