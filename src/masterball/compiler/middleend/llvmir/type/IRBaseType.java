package masterball.compiler.middleend.llvmir.type;

public abstract class IRBaseType {

    abstract public boolean match(IRBaseType other);

    abstract public int size(); // byte

    @Override
    abstract public String toString();
}
