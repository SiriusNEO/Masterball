package masterball.compiler.middleend.llvmir.type;

import java.util.ArrayList;

public class ClassType extends BaseType {
    public static String className;
    public ArrayList<BaseType> memberTypes = new ArrayList<>();

    @Override
    public boolean match(BaseType other) {
        return false;
    }

    @Override
    public int size() {
        int ret = 0;
        for (BaseType memberType : memberTypes) ret += memberType.size();
        return ret;
    }

    @Override
    public String toString() {
        return "%struct." + className;
    }
}
