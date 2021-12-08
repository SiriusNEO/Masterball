package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.Value;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.type.VoidType;
import masterball.compiler.share.LLVMTable;

public class IRRetInst extends IRBaseInst {

    public IRRetInst(IRBlock parentBlock) {
        super(LLVMTable.RetInst, new VoidType(), parentBlock);
    }

    public IRRetInst(Value retVal, IRBlock parentBlock) {
        super(LLVMTable.RetInst, retVal.type, parentBlock);
        this.addOperand(retVal);
    }

    public Value retVal() {
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
