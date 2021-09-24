package masterball.compiler.frontend.scope;

import masterball.compiler.frontend.type.Type;

import java.util.HashMap;

public class GlobalScope extends BaseScope {

    public HashMap<String, Registry> classRegTable, funcRegTable, varRegTable;

    @Override
    void query(String identifier) {

    }

    @Override
    void register(Registry registry) {
        if (registry.type.extendType == Type.ExtendType.FUNC) {
            funcRegTable.put(registry.identifier, registry);
        } else if (registry.type.extendType == Type.ExtendType.CLASS) {
            classRegTable.put(registry.identifier, registry);
        } else if (registry.type.extendType == Type.ExtendType.VAR) {
            varRegTable.put(registry.identifier, registry);
        }
    }
}
