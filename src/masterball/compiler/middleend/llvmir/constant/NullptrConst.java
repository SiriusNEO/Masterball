package masterball.compiler.middleend.llvmir.constant;

import masterball.compiler.middleend.llvmir.type.BaseType;
import masterball.compiler.middleend.llvmir.type.PointerType;
import masterball.compiler.middleend.llvmir.type.VoidType;
import masterball.compiler.utils.LLVMTable;

public class NullptrConst extends BaseConst {
    public NullptrConst() {
        super(LLVMTable.ConstAnon, new PointerType(new VoidType()));
    }

    @Override
    public String identifier() {return "null";}
}
