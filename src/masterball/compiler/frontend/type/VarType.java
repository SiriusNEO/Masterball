package masterball.compiler.frontend.type;

public class VarType extends Type {
    enum BasicType {INT, BOOL, STRING, CLASS};
    public String className;

    public int dimension;  // for Array Object

    public VarType() {
        super(ExtendType.VAR);
    }
}
