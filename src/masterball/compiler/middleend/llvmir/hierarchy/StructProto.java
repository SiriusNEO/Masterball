package masterball.compiler.middleend.llvmir.hierarchy;

import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.middleend.llvmir.type.StructType;

public class StructProto extends Value {
    public StructProto(String name, IRBaseType type) {
        super(name, type);
    }

    public StructType struct() {
        return (StructType) this.type;
    }
}
