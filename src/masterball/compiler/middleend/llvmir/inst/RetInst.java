package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.BaseValue;
import masterball.compiler.middleend.llvmir.hierarchy.Function;
import masterball.compiler.middleend.llvmir.type.VoidType;
import masterball.compiler.utils.LLVMTable;

public class RetInst extends BaseInst {

    public RetInst(Function parentFunc) {
        super(LLVMTable.RetInst, new VoidType(), parentFunc.exitBlock());
    }

    public RetInst(BaseValue retVal, Function parentFunc) {
        super(LLVMTable.RetInst, retVal.type, parentFunc.exitBlock());
        this.addOperand(retVal);
    }

    public BaseValue retVal() {
        return this.getOperand(0);
    }

    @Override
    public boolean isTerminator() {return true;}

    @Override
    public String format() {
        // ret i32 0
        // ret void
        String ret = LLVMTable.RetInst + " " + this.type;
        if (!this.type.match(new VoidType()))
            ret += " " + this.retVal().identifier();
        return ret;
    }
}
