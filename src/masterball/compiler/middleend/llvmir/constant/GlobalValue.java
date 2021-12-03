package masterball.compiler.middleend.llvmir.constant;

import masterball.compiler.middleend.llvmir.type.IRBaseType;

public class GlobalValue extends BaseConst {
    public GlobalValue(String name, IRBaseType type) {
        super(name, type);
    }

    @Override
    public String identifier() {return "@" + this.name;}
}
