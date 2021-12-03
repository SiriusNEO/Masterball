package masterball.compiler.middleend.llvmir.constant;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.middleend.llvmir.type.PointerType;

public class GlobalVariable extends GlobalValue {

    public GlobalVariable(String name, IRBaseType type) {
        super(name, new PointerType(type));
    }
}
