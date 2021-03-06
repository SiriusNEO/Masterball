package masterball.compiler.frontend.info.scope;

import masterball.compiler.share.error.semantic.NameError;
import masterball.compiler.frontend.info.registry.ClassRegistry;
import masterball.compiler.frontend.info.registry.FuncRegistry;
import masterball.compiler.frontend.info.registry.BaseRegistry;
import masterball.compiler.frontend.info.registry.VarRegistry;

public class NormalScope extends BaseScope {

    @Override
    public ClassRegistry queryClass(String name) {
        return null;
    }

    @Override
    public FuncRegistry queryFunc(String name) {
        return null;
    }

    @Override
    public VarRegistry queryVar(String name) {
        return varTable.get(name);
    }

    @Override
    public void register(BaseRegistry registry) {
        String name = registry.name;
        if (varTable.containsKey(name))
            throw new NameError(registry.codePos, NameError.redefined, name);
        varTable.put(name, (VarRegistry) registry);
    }

    public String toString() {
        StringBuilder ret = new StringBuilder("[NormalScope]\n");
        ret.append("VarTable: ").append(varTable.toString());
        return ret.toString();
    }
}
