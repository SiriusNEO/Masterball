package masterball.compiler.middleend.llvmir.constant;

import masterball.compiler.middleend.llvmir.type.BoolType;
import masterball.compiler.share.LLVMTable;

public class BoolConst extends BaseConst {
    public boolean constData;

    public BoolConst(boolean constData) {
        super(LLVMTable.ConstAnon, new BoolType());
        this.constData = constData;
    }

    @Override
    public String identifier() {
        return constData ? "true" : "false";
    }
}
