package masterball.compiler.middleend.llvmir.type;

import java.util.ArrayList;

public class StructType extends IRBaseType {
    public static String structName;
    public ArrayList<IRBaseType> memberTypes = new ArrayList<>();

    @Override
    public boolean match(IRBaseType other) {
        return false;
    }

    @Override
    public int size() {
        int ret = 0;
        for (IRBaseType memberType : memberTypes) ret += memberType.size();
        return ret;
    }

    @Override
    public String toString() {
        return "%struct." + structName;
    }
}
