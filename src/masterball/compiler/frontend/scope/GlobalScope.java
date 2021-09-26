package masterball.compiler.frontend.scope;

import masterball.compiler.frontend.error.semantic.NameReDefined;
import masterball.compiler.frontend.info.*;

import java.util.HashMap;

public class GlobalScope extends BaseScope {

    public HashMap<String, ClassRegistry> classTable;
    public HashMap<String, FuncRegistry> funcTable;
    public HashMap<String, VarRegistry> varTable;

    public GlobalScope() {
        this.classTable = new HashMap<String, ClassRegistry>();
        this.funcTable = new HashMap<String, FuncRegistry>();
        this.varTable = new HashMap<String, VarRegistry>();
    }

    @Override
    public void query(String identifier) {

    }

    @Override
    public void register(Registry registry) {
        String name = registry.name;
        if (classTable.containsKey(name) || funcTable.containsKey(name) || varTable.containsKey(name))
            throw new NameReDefined(registry.codePos, name);
        if (registry instanceof ClassRegistry) {
            classTable.put(name, (ClassRegistry) registry);
        } else if (registry instanceof FuncRegistry) {
            funcTable.put(name, (FuncRegistry) registry);
        } else if (registry instanceof VarRegistry) {
            varTable.put(name, (VarRegistry) registry);
        }
    }
}
