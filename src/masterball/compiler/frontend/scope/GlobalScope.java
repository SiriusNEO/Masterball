package masterball.compiler.frontend.scope;

import masterball.compiler.frontend.type.Type;

import java.util.HashMap;

public class GlobalScope extends BaseScope {

    public HashMap<String, Registry> classRegTable, funcRegTable, varRegTable;

    @Override
    void query(String name) {

    }

    @Override
    void register(Registry registry) {
        if (registry.type.extendType == Type.ExtendType.FUNC) { // register function

        } else if (registry.type.extendType == Type.ExtendType.CLASS) { // register class

        } else if (registry.type.extendType == Type.ExtendType.VAR) { //

        }
    }
}
