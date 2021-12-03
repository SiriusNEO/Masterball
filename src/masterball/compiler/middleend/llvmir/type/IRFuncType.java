package masterball.compiler.middleend.llvmir.type;

import java.util.ArrayList;

public class IRFuncType extends IRBaseType {
    public IRBaseType retType;
    public ArrayList<IRBaseType> argTypes;

    // init retType
    public IRFuncType(IRBaseType retType) {
        this.retType = retType;
        argTypes = new ArrayList<IRBaseType>();
    }

    @Override
    public boolean match(IRBaseType other) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String toString() {
        return retType.toString();
    }
}
