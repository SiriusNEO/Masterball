package masterball.compiler.middleend.llvmir.constant;

import masterball.compiler.middleend.llvmir.User;
import masterball.compiler.middleend.llvmir.type.IRBaseType;

public abstract class BaseConst extends User {
    public BaseConst(String name, IRBaseType type) {
        super(name, type);
    }
}
