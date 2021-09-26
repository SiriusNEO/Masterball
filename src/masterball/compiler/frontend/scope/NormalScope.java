package masterball.compiler.frontend.scope;

import masterball.compiler.frontend.error.semantic.NameReDefined;
import masterball.compiler.frontend.info.Registry;
import masterball.compiler.frontend.info.VarRegistry;

import java.util.HashMap;

public class NormalScope extends BaseScope {

    public HashMap<String, VarRegistry> varTable;

    @Override
    void query(String name) {

    }

    @Override
    void register(Registry registry) {
        String name = registry.name;
        if (varTable.containsKey(name))
            throw new NameReDefined(registry.codePos, name);
        varTable.put(name, (VarRegistry) registry);
    }
}
