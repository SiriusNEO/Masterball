package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.Value;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.share.LLVMTable;

public class IRZextInst extends IRBaseInst {

    public IRZextInst(Value fromValue, IRBaseType targetType, IRBlock parentBlock) {
        super(LLVMTable.ZextInst, targetType, parentBlock);
        this.addOperand(fromValue);
    }

    public Value fromValue() {return this.getOperand(0);}

    @Override
    public String format() {
        // %zext = zext i8 %a to i32;
        return this.identifier() + " = " + LLVMTable.ZextInst + " " + this.fromValue().typedIdentifier()
                + " to " + this.type;
    }
}
