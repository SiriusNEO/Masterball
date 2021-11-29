package masterball.compiler.middleend.llvmir.constant;

import masterball.compiler.middleend.llvmir.hierarchy.BaseUser;
import masterball.compiler.middleend.llvmir.type.BaseType;

public class BaseConst extends BaseUser {
    public BaseConst(String name, BaseType type) {
        super(name, type);
    }
}
