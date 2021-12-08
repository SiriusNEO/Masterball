package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.Value;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.share.LLVMTable;

public class IRBitCastInst extends IRBaseInst {
    public IRBitCastInst(Value fromValue, IRBaseType targetType, IRBlock parentBlock) {
        super(LLVMTable.BitCastInst, targetType, parentBlock);
        this.addOperand(fromValue);
    }

    public Value fromValue() {return this.getOperand(0);}

    @Override
    public String format() {
        // %bitcast = bitcast i8** %a to i8*;
        return this.identifier() + " = " + LLVMTable.BitCastInst + " " + this.fromValue().typedIdentifier()
                + " to " + this.type;
    }
}
