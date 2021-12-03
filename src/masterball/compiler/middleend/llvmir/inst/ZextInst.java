package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.BaseValue;
import masterball.compiler.middleend.llvmir.hierarchy.BasicBlock;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.utils.LLVMTable;

public class ZextInst extends BaseInst {

    public ZextInst(BaseValue fromValue, IRBaseType targetType, BasicBlock parentBlock) {
        super(LLVMTable.ZextInst, targetType, parentBlock);
        this.addOperand(fromValue);
    }

    public BaseValue fromValue() {return this.getOperand(0);}

    @Override
    public String format() {
        // %zext = zext i8 %a to i32;
        return this.identifier() + " = " + LLVMTable.ZextInst + " " + this.fromValue().typedIdentifier()
                + " to " + this.type;
    }
}
