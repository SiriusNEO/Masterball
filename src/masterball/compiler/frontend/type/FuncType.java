package masterball.compiler.frontend.type;

import java.util.ArrayList;

public class FuncType extends Type {
    public boolean isRetVoid;
    public Type retType;
    public ArrayList<Type> argsTypes;

    public FuncType(boolean isRetVoid, Type retType) {
        super(ExtendType.FUNC);
        this.isRetVoid = isRetVoid;
        this.retType = retType;
        this.argsTypes = new ArrayList<Type>();
    }
}
