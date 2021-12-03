package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.BaseValue;
import masterball.compiler.middleend.llvmir.hierarchy.BasicBlock;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.utils.LLVMTable;

public class TruncInst extends BaseInst {

    public TruncInst(BaseValue fromValue, IRBaseType targetType, BasicBlock parentBlock) {
        super(LLVMTable.TruncInst, targetType, parentBlock);
        this.addOperand(fromValue);
    }

    public BaseValue fromValue() {return this.getOperand(0);}

    @Override
    public String format() {
        // %trunc = trunc i32 %a to i8;
        return this.identifier() + " = " + LLVMTable.TruncInst + " " + this.fromValue().typedIdentifier()
                + " to " + this.type;
    }
}
