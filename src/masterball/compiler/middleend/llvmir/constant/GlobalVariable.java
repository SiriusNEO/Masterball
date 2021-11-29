package masterball.compiler.middleend.llvmir.constant;
import masterball.compiler.middleend.llvmir.type.BaseType;
import masterball.compiler.middleend.llvmir.type.PointerType;

public class GlobalVariable extends GlobalValue {

    public GlobalVariable(String name, BaseType type) {
        super(name, new PointerType(type));
    }
}
