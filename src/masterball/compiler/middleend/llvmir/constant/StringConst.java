package masterball.compiler.middleend.llvmir.constant;

import masterball.compiler.middleend.llvmir.type.ArrayType;
import masterball.compiler.middleend.llvmir.type.BaseType;
import masterball.compiler.middleend.llvmir.type.IntType;
import masterball.compiler.utils.LLVMTable;

public class StringConst extends BaseConst {

    public String constData;

    public StringConst(String constData) {
        super(LLVMTable.ConstAnon, new ArrayType(new IntType(8), constData.length()));
        this.constData = constData;
    }

    @Override
    public String identifier() {
        //TODO: implement it
        return null;
    }
}
