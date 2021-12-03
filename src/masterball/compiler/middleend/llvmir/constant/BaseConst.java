package masterball.compiler.middleend.llvmir.constant;

import masterball.compiler.middleend.llvmir.hierarchy.BaseUser;
import masterball.compiler.middleend.llvmir.type.IRBaseType;

public class BaseConst extends BaseUser {
    public BaseConst(String name, IRBaseType type) {
        super(name, type);
    }
}
