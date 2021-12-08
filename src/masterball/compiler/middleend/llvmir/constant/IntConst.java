package masterball.compiler.middleend.llvmir.constant;

import masterball.compiler.middleend.llvmir.type.IntType;
import masterball.compiler.share.LLVMTable;

public class IntConst extends BaseConst {
    public int constData;

    public IntConst(int constData) {
        super(LLVMTable.ConstAnon, new IntType());
        this.constData = constData;
    }

    public IntConst(int constData, int bitWidth) {
        super(LLVMTable.ConstAnon, new IntType(bitWidth));
        this.constData = constData;
    }

    // constant identifier: simply a number
    @Override
    public String identifier() {
        return String.valueOf(constData);
    }
}
