package masterball.compiler.frontend.info.type;

public abstract class MxBaseType {
    public enum BuiltinType {NULL, INT, BOOL, STRING, VOID, CLASS, FUNC}

    public BuiltinType builtinType;

    public abstract boolean match(MxBaseType other);

    public abstract boolean match(BuiltinType other);

    public abstract MxBaseType copy();

    public MxBaseType(BuiltinType builtinType) {
        this.builtinType = builtinType;
    }
}
