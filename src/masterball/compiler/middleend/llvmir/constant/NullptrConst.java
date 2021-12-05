package masterball.compiler.middleend.llvmir.constant;

import masterball.compiler.middleend.llvmir.IRTranslator;
import masterball.compiler.utils.LLVMTable;

public class NullptrConst extends BaseConst {
    public NullptrConst() {
        super(LLVMTable.ConstAnon, IRTranslator.nullType);
    }

    @Override
    public String identifier() {return "null";}
}
