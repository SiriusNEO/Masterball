package masterball.compiler.frontend.scope;

import masterball.compiler.frontend.error.semantic.NameError;
import masterball.compiler.frontend.info.ClassRegistry;
import masterball.compiler.frontend.info.FuncRegistry;
import masterball.compiler.frontend.info.Registry;
import masterball.compiler.frontend.info.VarRegistry;

import java.util.HashMap;

public class ClassScope extends BaseScope {

    public HashMap<String, VarRegistry> varTable;
    public HashMap<String, FuncRegistry> funcTable;

    public ClassScope() {
        this.varTable = new HashMap<>();
        this.funcTable = new HashMap<>();
    }

    @Override
    public ClassRegistry queryClass(String name) {
        return null;
    }

    @Override
    public FuncRegistry queryFunc(String name) {
        return funcTable.get(name);
    }

    @Override
    public VarRegistry queryVar(String name) {
        return varTable.get(name);
    }

    @Override
    public void register(Registry registry) {
        String name = registry.name;
        if (registry instanceof FuncRegistry) {
            if (funcTable.containsKey(name))
                throw new NameError(registry.codePos, NameError.redefined , name);
            funcTable.put(name, (FuncRegistry) registry);
        } else if (registry instanceof VarRegistry) {
            if (varTable.containsKey(name))
                throw new NameError(registry.codePos, NameError.redefined , name);
            varTable.put(name, (VarRegistry) registry);
        }
    }

    public String toString() {
        StringBuilder ret = new StringBuilder("[ClassScope]\n");
        ret.append("VarTable: ").append(varTable.toString()).append("\n");
        ret.append("FuncTable: ").append(funcTable.toString()).append("\n");
        return ret.toString();
    }
}
