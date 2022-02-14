package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.IRTranslator;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.share.lang.LLVM;
import masterball.compiler.share.pass.InstVisitor;

// It is a fake instruction which can not be recognized by llc
// It is value itself is meaningless (void inst)
// created by SSADestructor

public class IRMoveInst extends IRBaseInst {

    public IRMoveInst(Value dest, Value source, IRBlock parentBlock) {
        super(LLVM.MoveInst, IRTranslator.voidType, parentBlock);
        this.addOperand(dest);
        this.addOperand(source);

        dest.moveDefs.add(this);
    }

    public Value dest() {
        return this.getOperand(0);
    }

    public Value source() {
        return this.getOperand(1);
    }

    @Override
    public String format() {
        return LLVM.MoveInst + " " + this.dest().identifier() + ", " + this.source().identifier();
        /*
        IRBaseInst substitutedInst;
        if (dest().type.match(IRTranslator.i32Type) || dest().type.match(IRTranslator.boolType)) {
            substitutedInst = new IRBinaryInst(LLVM.AddInst, dest().type, source(), new IntConst(0), null);
        }
        else
            substitutedInst = new IRGetElementPtrInst(source(), source().type, null, new IntConst(0));
        substitutedInst.name = dest().name;
        return substitutedInst.format();
        */
    }

    @Override
    public IRBaseInst copy() {
        return new IRMoveInst(dest(), source(), null);
    }

    @Override
    public void accept(InstVisitor visitor) {
        visitor.visit(this);
    }
}
