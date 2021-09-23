package masterball.compiler.frontend.type;

import java.util.HashMap;

public class ClassType extends Type {

    public HashMap<String, VarType> memberVarTypes;
    public HashMap<String, FuncType> memberFuncTypes;

    public ClassType() {
        super(ExtendType.CLASS);
        memberVarTypes = new HashMap<String, VarType>();
        memberFuncTypes = new HashMap<String, FuncType>();
    }
}
