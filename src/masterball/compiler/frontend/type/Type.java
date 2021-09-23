package masterball.compiler.frontend.type;

public abstract class Type {
    public enum ExtendType {VAR, FUNC, CLASS};
    public ExtendType extendType;

    Type(ExtendType extendType) {
        this.extendType = extendType;
    }
}
