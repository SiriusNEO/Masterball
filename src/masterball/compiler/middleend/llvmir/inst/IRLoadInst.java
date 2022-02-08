package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.type.PointerType;
import masterball.compiler.share.lang.LLVM;
import masterball.compiler.share.pass.InstVisitor;

public class IRLoadInst extends IRBaseInst {
    public IRLoadInst(Value loadPtr, IRBlock parentBlock) {
        super(resolveRename(loadPtr.name),
              ((PointerType) loadPtr.type).pointedType,
              parentBlock);
        this.addOperand(loadPtr);
    }

    public Value loadPtr() {
        return this.getOperand(0);
    }

    public void replacePtr(Value value) {this.resetOperand(0, value);}

    @Override
    public boolean mayHaveSideEffects() {return true;}

    @Override
    public String format() {
        // %load = load <type>, <type*> %destPtr, align <size>
        return this.identifier() + " = " + LLVM.LoadInst + " " + this.type + ", " +
                this.loadPtr().typedIdentifier() + ", align " + this.type.size();
    }

    @Override
    public void accept(InstVisitor visitor) {
        visitor.visit(this);
    }
}
