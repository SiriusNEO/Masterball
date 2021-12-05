package masterball.compiler.middleend.llvmir.constant;
import masterball.compiler.middleend.llvmir.hierarchy.BaseValue;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.middleend.llvmir.type.IRFuncType;
import masterball.compiler.middleend.llvmir.type.PointerType;

public class GlobalVariable extends GlobalValue {

    // global var is a pointer

    public GlobalVariable(String name, IRBaseType type) {
        super(name, new PointerType(type));
    }

    public IRBaseType pointedType() {
        return ((PointerType) this.type).pointedType;
    }
}
