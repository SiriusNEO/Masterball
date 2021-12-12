package masterball.compiler.middleend.llvmir.constant;

import masterball.compiler.middleend.llvmir.type.IntType;
import masterball.compiler.share.lang.LLVM;

public class IntConst extends BaseConst {
    public int constData;

    public IntConst(int constData) {
        super(LLVM.ConstAnon, new IntType());
        this.constData = constData;
    }

    public IntConst(int constData, int bitWidth) {
        super(LLVM.ConstAnon, new IntType(bitWidth));
        this.constData = constData;
    }

    // constant identifier: simply a number
    @Override
    public String identifier() {
        return String.valueOf(constData);
    }
}
