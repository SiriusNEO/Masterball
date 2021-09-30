package masterball.compiler.frontend.scope;

import masterball.compiler.frontend.info.type.BaseType;
import masterball.compiler.frontend.info.type.VarType;

public class FuncScope extends NormalScope {

    public VarType catchedRet = new VarType(BaseType.BuiltinType.VOID);

}
