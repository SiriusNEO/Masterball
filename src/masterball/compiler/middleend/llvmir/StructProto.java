package masterball.compiler.middleend.llvmir;

import masterball.compiler.middleend.llvmir.Value;
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
