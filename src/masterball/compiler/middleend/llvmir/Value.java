package masterball.compiler.middleend.llvmir;

import masterball.compiler.backend.rvasm.operand.BaseOperand;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.share.lang.LLVM;

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
        return rawName + LLVM.AddrSuffix;
    }

    public static String resolveRename(String rawName) {
        int lastAddrSuffixIndex = rawName.lastIndexOf(LLVM.AddrSuffix);
        if (lastAddrSuffixIndex < 0) return rawName + LLVM.ResolveSuffix;
        return rawName.substring(0, lastAddrSuffixIndex) + LLVM.ResolveSuffix;
    }

    public IRBaseType type;
    public ArrayList<User> users = new ArrayList<User>();
    public Value resolveFrom = null;
    public String name;
    public String comment = null;

    // interact with BackEnd
    public BaseOperand asmOperand = null;

    public Value(IRBaseType type) {
        this.name = LLVM.TypeAnon;
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
        return LLVM.CommentPrefix + comment;
    }
}
