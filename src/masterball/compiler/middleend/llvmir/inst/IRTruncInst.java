package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.Value;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.share.LLVMTable;

public class IRTruncInst extends IRBaseInst {

    public IRTruncInst(Value fromValue, IRBaseType targetType, IRBlock parentBlock) {
        super(LLVMTable.TruncInst, targetType, parentBlock);
        this.addOperand(fromValue);
    }

    public Value fromValue() {return this.getOperand(0);}

    @Override
    public String format() {
        // %trunc = trunc i32 %a to i8;
        return this.identifier() + " = " + LLVMTable.TruncInst + " " + this.fromValue().typedIdentifier()
                + " to " + this.type;
    }
}
