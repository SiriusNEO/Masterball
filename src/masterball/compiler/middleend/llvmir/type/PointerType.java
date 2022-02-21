package masterball.compiler.middleend.llvmir.type;

import masterball.compiler.middleend.llvmir.IRTranslator;
import masterball.compiler.share.lang.LLVM;

public class PointerType extends IRBaseType {
    public IRBaseType pointedType;
    public int dimension;

    public PointerType(IRBaseType pointed) {
        this.pointedType = pointed;
        if (pointed instanceof PointerType) this.dimension = ((PointerType)pointed).dimension + 1;
        else this.dimension = 1;
    }

    @Override
    public boolean match(IRBaseType other) {
        // pointer match: pointedType match and dimension match
        // nullptr judge: if other is nullptr, return true
        if (other instanceof PointerType) {
            return (
                    (((PointerType) other).dimension == dimension && ((PointerType) other).pointedType.match(pointedType))
                    || other.equals(IRTranslator.nullType)
            );
        }
        else if (other instanceof ArrayType) {
            return this.match(IRTranslator.stringType);
        }
        return false;
    }

    @Override
    public int size() {
        return LLVM.PointerSize;
    }

    @Override
    public String toString() {
        return pointedType + "*";
    }
}
