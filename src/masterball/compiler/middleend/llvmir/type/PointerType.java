package masterball.compiler.middleend.llvmir.type;

import masterball.compiler.utils.LLVMTable;

public class PointerType extends BaseType {
    public BaseType pointed;
    public int dimension;

    public PointerType(BaseType pointed) {
        this.pointed = pointed;
        if (pointed instanceof PointerType) this.dimension = ((PointerType)pointed).dimension + 1;
        else this.dimension = 1;
    }

    @Override
    public boolean match(BaseType other) {
        return false;
    }

    @Override
    public int size() {
        return LLVMTable.PointerSize;
    }

    @Override
    public String toString() {
        return pointed + "*";
    }
}
