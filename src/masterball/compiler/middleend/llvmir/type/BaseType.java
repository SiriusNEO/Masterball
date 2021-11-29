package masterball.compiler.middleend.llvmir.type;

public abstract class BaseType {

    abstract public boolean match(BaseType other);

    abstract public int size(); // byte

    @Override
    abstract public String toString();
}
