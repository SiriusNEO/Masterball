package masterball.compiler.frontend.info.scope;

import masterball.compiler.frontend.info.registry.VarRegistry;
import masterball.compiler.frontend.info.type.VarType;

import java.util.ArrayList;

public class FuncScope extends NormalScope {

    public ArrayList<VarType> catchedRetTypeList = new ArrayList<>();
}
