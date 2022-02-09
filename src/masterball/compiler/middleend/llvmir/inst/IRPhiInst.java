package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.share.lang.LLVM;
import masterball.compiler.share.error.runtime.UnknownError;
import masterball.compiler.share.pass.InstVisitor;

import java.util.HashSet;
import java.util.Set;

// number of PhiInst operands must be even

public class IRPhiInst extends IRBaseInst {

    // some IRPhiInst will deteriorate to MoveInst (e.g. see @SCCP Pass)
    // due to MoveInst is a void inst, if a Phi deteriorated, use these to query the move
    public Set<IRMoveInst> collapsedMoves = new HashSet<>();

    public IRPhiInst(IRBaseType yieldType, IRBlock parentBlock, Value... operands) {
        super(LLVM.PhiInst, yieldType, parentBlock);

        for (Value operand : operands) this.addOperand(operand);

        if (operands.length % 2 != 0) throw new UnknownError(this);
    }

    public void addBranch(Value branchData, IRBlock preBlock) {
        this.addOperand(branchData);
        this.addOperand(preBlock);
    }

    @Override
    public String format() {
        // %indvar = phi i32 [ 0, %LoopHeader ], [ %nextindvar, %Loop ]
        String ret = this.identifier() + " = " + LLVM.PhiInst + " " + this.type + " ";

        for (int i = 0; i < this.operandSize(); i += 2) {
            ret += "[" + this.getOperand(i).identifier() + ", " + this.getOperand(i+1).identifier() + "]";
            if (i < this.operandSize() - 2) ret += ", ";
        }

        return ret;
    }

    @Override
    public IRBaseInst copy() {
        return null;
    }

    @Override
    public void accept(InstVisitor visitor) {
        visitor.visit(this);
    }
}
