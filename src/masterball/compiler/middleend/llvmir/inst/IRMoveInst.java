package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.IRTranslator;
import masterball.compiler.middleend.llvmir.constant.IntConst;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.Value;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.share.LLVMTable;

public class IRMoveInst extends IRBaseInst {
    public IRMoveInst(Value dest, Value source, IRBlock parentBlock) {
        super(LLVMTable.MoveInst, IRTranslator.voidType, parentBlock);
        this.addOperand(dest);
        this.addOperand(source);
    }

    public Value dest() {
        return this.getOperand(0);
    }

    public Value source() {
        return this.getOperand(1);
    }

    @Override
    public String format() {
        return LLVMTable.MoveInst + " " + this.dest().identifier() + ", " + this.source().identifier();
        /*
        IRBaseInst substitutedInst;
        if (dest().type.match(IRTranslator.i32Type) || dest().type.match(IRTranslator.boolType)) {
            substitutedInst = new IRBinaryInst(LLVMTable.AddInst, dest().type, source(), new IntConst(0), null);
        }
        else
            substitutedInst = new IRGetElementPtrInst(source(), source().type, null, new IntConst(0));
        substitutedInst.name = dest().name;
        return substitutedInst.format();
        */
    }
}
