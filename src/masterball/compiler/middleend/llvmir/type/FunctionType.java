package masterball.compiler.middleend.llvmir.type;

import java.util.ArrayList;

public class FunctionType extends BaseType {
    public BaseType retType;
    public ArrayList<BaseType> argTypes;

    // init retType
    public FunctionType(BaseType retType) {
        this.retType = retType;
        argTypes = new ArrayList<BaseType>();
    }

    @Override
    public boolean match(BaseType other) {
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
