package masterball.compiler.middleend.llvmir.hierarchy;

import masterball.compiler.middleend.llvmir.inst.BaseInst;
import masterball.compiler.middleend.llvmir.type.BaseType;
import masterball.compiler.utils.LLVMTable;

import java.util.ArrayList;
import java.util.HashMap;


public class BaseValue {
    public static Boolean rename = false;
    public static HashMap<String, Integer> renameTable = new HashMap<>();

    public static String rename(String rawName) {
        if (!rename) return rawName;
        Integer renameCnt = renameTable.get(rawName);
        if (renameCnt == null) renameCnt = 0;
        renameTable.put(rawName, renameCnt+1);
        if (renameCnt == 0) return rawName;
        return rawName + renameCnt;
    }

    public BaseType type;
    public ArrayList<BaseUser> users = new ArrayList<BaseUser>();
    public String name;

    public BaseValue(String name, BaseType type) {
        this.name = rename(name);
        this.type = type;
    }

    public void addUser(BaseUser user) {
        users.add(user);
    }

    public String identifier() {
        return "%" + name;
    }
}
