package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.type.IRFuncType;
import masterball.compiler.middleend.llvmir.type.VoidType;
import masterball.compiler.share.lang.LLVM;
import masterball.compiler.share.pass.InstVisitor;

import java.util.ArrayList;

public class IRCallInst extends IRBaseInst {

    private boolean noaliasFlag = false;

    public boolean isTailCall = false;

    public IRCallInst(IRFunction callFunc, IRBlock parentBlock, ArrayList<Value> callArgs) {
        super(callFunc.name + LLVM.CallSuffix,
                ((IRFuncType) callFunc.type).retType,
                parentBlock);
        this.addOperand(callFunc);
        for (int i = 0; i < callArgs.size(); i++) this.addOperand(callArgs.get(i));
    }

    public IRCallInst(IRFunction callFunc, IRBlock parentBlock, Value... callArgs) {
        super(callFunc.name + LLVM.CallSuffix,
                ((IRFuncType) callFunc.type).retType,
                parentBlock);
        this.addOperand(callFunc);
        for (Value arg : callArgs) this.addOperand(arg);
    }

    public IRFunction callFunc() {
        return (IRFunction) this.getOperand(0);
    }

    public Value getArg(int index) {
        return this.getOperand(index+1);
    }

    // noalias is for LLVM IR "noalias" keyword

    public IRCallInst noalias() {
        noaliasFlag = true;
        return this;
    }

    @Override
    public boolean mayHaveSideEffects() {return true;}

    @Override
    public String format() {
        // %call = call i32 @foo(i32 1)
        StringBuilder ret = new StringBuilder((this.type.match(new VoidType())) ? "" : this.identifier() + " = ");
        ret.append(LLVM.CallInst + " ");
        if (noaliasFlag) ret.append("noalias ");
        ret.append(this.callFunc().typedIdentifier()).append("(");
        for (int i = 0; i < this.callFunc().getArgNum(); i++) {
            ret.append(this.callFunc().getArgType(i)).append(" ").append(this.getArg(i).identifier());
            if (i != this.callFunc().getArgNum() - 1) ret.append(", ");
        }
        ret.append(")");
        return ret.toString();
    }

    @Override
    public IRBaseInst copy() {
        ArrayList<Value> args = new ArrayList<Value>();
        for (int i = 0; i < this.callFunc().getArgNum(); i++)
            args.add(getArg(i));
        return new IRCallInst(callFunc(), null, args);
    }

    @Override
    public void accept(InstVisitor visitor) {
        visitor.visit(this);
    }
}
