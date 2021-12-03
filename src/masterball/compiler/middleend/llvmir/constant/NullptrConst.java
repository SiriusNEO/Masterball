package masterball.compiler.middleend.llvmir.constant;

import masterball.compiler.middleend.IRTranslator;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.middleend.llvmir.type.PointerType;
import masterball.compiler.middleend.llvmir.type.VoidType;
import masterball.compiler.utils.LLVMTable;

import static masterball.compiler.middleend.IRTranslator.heapPointerType;

public class NullptrConst extends BaseConst {
    public NullptrConst() {
        super(LLVMTable.ConstAnon, IRTranslator.nullType);
    }

    @Override
    public String identifier() {return "null";}
}
