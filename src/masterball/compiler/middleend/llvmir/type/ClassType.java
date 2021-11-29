package masterball.compiler.middleend.llvmir.type;

public class ClassType extends BaseType {
    @Override
    public boolean match(BaseType other) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }
}
