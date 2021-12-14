package masterball.compiler.middleend.llvmir.type;

import masterball.compiler.middleend.llvmir.StructProto;
import masterball.compiler.share.lang.LLVM;
import masterball.debug.Log;

import java.util.ArrayList;
import java.util.Objects;

public class StructType extends IRBaseType {
    public final String structName;
    public final StructProto structProto;
    public ArrayList<IRBaseType> memberVarTypes = new ArrayList<>();

    public StructType(String structName) {
        this.structName = structName;
        structProto = new StructProto(LLVM.StructPrefix + structName, this);
    }

    @Override
    public boolean match(IRBaseType other) {
        return other instanceof StructType && Objects.equals(structName, ((StructType) other).structName);
    }

    @Override
    public int size() {
        int ret = 0;
        for (IRBaseType memberVarType : memberVarTypes) ret += memberVarType.size();
        return ret;
    }

    // e.g. struct {i32 a, i8 b, i32 c}
    // index 0 1 2
    // offset 0 4 5
    public int memberOffset(int index) {
        int ret = 0;
        for (int i = 0; i < index; ++i) ret += memberVarTypes.get(i).size();
        return ret;
    }

    @Override
    public String toString() {
        return structProto.identifier();
    }
}
