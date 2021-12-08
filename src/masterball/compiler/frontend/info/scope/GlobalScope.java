package masterball.compiler.frontend.info.scope;

import masterball.compiler.share.error.semantic.NameError;
import masterball.compiler.frontend.info.registry.ClassRegistry;
import masterball.compiler.frontend.info.registry.FuncRegistry;
import masterball.compiler.frontend.info.registry.BaseRegistry;
import masterball.compiler.frontend.info.registry.VarRegistry;

import java.util.ArrayList;
import java.util.HashMap;

public class GlobalScope extends BaseScope {

    public HashMap<String, ClassRegistry> classTable;
    public HashMap<String, FuncRegistry> funcTable;
    public ArrayList<FuncRegistry> builtinFuncList;

    public GlobalScope() {
        this.classTable = new HashMap<>();
        this.funcTable = new HashMap<>();
        this.varTable = new HashMap<>();
        this.builtinFuncList = new ArrayList<>();
    }

    @Override
    public ClassRegistry queryClass(String name) {
        return classTable.get(name);
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
    public void register(BaseRegistry registry) {
        String name = registry.name;
        if (classTable.containsKey(name))
            throw new NameError(registry.codePos, NameError.redefined , name);
        if (registry instanceof ClassRegistry) {
            if (funcTable.containsKey(name) || varTable.containsKey(name))
                throw new NameError(registry.codePos, NameError.redefined , name);
            classTable.put(name, (ClassRegistry) registry);
        } else if (registry instanceof FuncRegistry) {
            if (funcTable.containsKey(name))
                throw new NameError(registry.codePos, NameError.redefined , name);
            funcTable.put(name, (FuncRegistry) registry);
            if (((FuncRegistry) registry).isBuiltin) {
                builtinFuncList.add((FuncRegistry) registry);
            }
        } else if (registry instanceof VarRegistry) {
            if (varTable.containsKey(name))
                throw new NameError(registry.codePos, NameError.redefined , name);
            varTable.put(name, (VarRegistry) registry);
        }
    }

    public String toString() {
        StringBuilder ret = new StringBuilder("[GlobalScope]\n");
        ret.append("VarTable: ").append(varTable.toString()).append("\n");
        ret.append("FuncTable: ").append(funcTable.toString()).append("\n");
        ret.append("ClassTable: ").append(classTable.toString());
        return ret.toString();
    }
}
