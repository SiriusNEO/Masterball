package masterball.compiler.share.misc;

// this implements a simple UnionSet in java

import java.util.HashMap;
import java.util.Map;

public class UnionSet<ObjType> {

    private final Map<ObjType, ObjType> aliasMap = new HashMap<>();

    // obj -> alias
    public void setAlias(ObjType obj, ObjType alias) {
        aliasMap.put(obj, alias);
    }

    public ObjType getAlias(ObjType obj) {
        if (!aliasMap.containsKey(obj)) return obj;
        ObjType alias = getAlias(aliasMap.get(obj));
        aliasMap.put(obj, alias);
        return alias;
    }

    public boolean contains(ObjType obj) {
        return aliasMap.containsKey(obj);
    }

    public void remove(ObjType obj) {
        aliasMap.remove(obj);
    }

    public void clear() {
        aliasMap.clear();
    }
}
