package masterball.compiler.frontend.info.type;

import org.antlr.v4.runtime.CodePointBuffer;

import java.util.Objects;

public abstract class BaseType {
    public enum BuiltinType {NULL, INT, BOOL, STRING, VOID, CLASS, FUNC}

    public BuiltinType builtinType;

    public abstract boolean match(BaseType other);

    public abstract boolean match(BuiltinType other);

    public abstract BaseType copy();

    public BaseType(BuiltinType builtinType) {
        this.builtinType = builtinType;
    }
}
