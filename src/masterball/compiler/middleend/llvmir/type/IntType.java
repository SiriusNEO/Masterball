package masterball.compiler.middleend.llvmir.type;

public class IntType extends BaseType {
    public final int bitWidth;

    public IntType() {
        this.bitWidth = 32;
    }

    public IntType(int bitWidth) {
        this.bitWidth = bitWidth;
    }

    @Override
    public boolean match(BaseType other) {
        return other instanceof IntType && ((IntType) other).bitWidth == bitWidth;
    }

    @Override
    public int size() {
        return bitWidth / 8;
    }

    @Override
    public String toString() {
        return "i" + bitWidth;
    }
}
