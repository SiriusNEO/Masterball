package masterball.compiler.middleend.llvmir.constant;

import masterball.compiler.middleend.llvmir.type.BaseType;

public class GlobalValue extends BaseConst {
    public GlobalValue(String name, BaseType type) {
        super(name, type);
    }

    @Override
    public String identifier() {return "@" + this.name;}
}
