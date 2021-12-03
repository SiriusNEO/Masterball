package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.BaseValue;
import masterball.compiler.middleend.llvmir.hierarchy.BasicBlock;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.utils.LLVMTable;

public class BitCastInst extends BaseInst {
    public BitCastInst(BaseValue fromValue, IRBaseType targetType, BasicBlock parentBlock) {
        super(LLVMTable.BitCastInst, targetType, parentBlock);
        this.addOperand(fromValue);
    }

    public BaseValue fromValue() {return this.getOperand(0);}

    @Override
    public String format() {
        // %bitcast = bitcast i8** %a to i8*;
        return this.identifier() + " = " + LLVMTable.BitCastInst + " " + this.fromValue().typedIdentifier()
                + " to " + this.type;
    }
}
