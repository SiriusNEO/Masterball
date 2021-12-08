package masterball.compiler.middleend.llvmir.hierarchy;

import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.share.LLVMTable;

import java.util.ArrayList;
import java.util.HashMap;


public class Value {
    // value rename
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

    public static String addrRename(String rawName) {
        return rawName + LLVMTable.AddrSuffix;
    }

    public static String resolveRename(String rawName) {
        int lastAddrSuffixIndex = rawName.lastIndexOf(LLVMTable.AddrSuffix);
        if (lastAddrSuffixIndex < 0) return rawName + LLVMTable.ResolveSuffix;
        return rawName.substring(0, lastAddrSuffixIndex) + LLVMTable.ResolveSuffix;
    }

    public IRBaseType type;
    public ArrayList<User> users = new ArrayList<User>();
    public Value resolveFrom = null;
    public String name;
    public String comment = null;

    public Value(IRBaseType type) {
        this.name = LLVMTable.TypeAnon;
        this.type = type;
    }

    public Value(String name, IRBaseType type) {
        this.name = rename(name);
        this.type = type;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public String identifier() {
        return "%" + name;
    }

    public String typedIdentifier() {
        return type + " " + identifier();
    }

    public String commentFormat() {
        if (comment == null) return "";
        return LLVMTable.CommentPrefix + comment;
    }
}
