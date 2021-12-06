package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.BaseValue;
import masterball.compiler.middleend.llvmir.hierarchy.BasicBlock;
import masterball.compiler.middleend.llvmir.hierarchy.Function;
import masterball.compiler.middleend.llvmir.type.IRFuncType;
import masterball.compiler.middleend.llvmir.type.VoidType;
import masterball.compiler.utils.LLVMTable;
import masterball.debug.Log;

import java.util.ArrayList;

public class CallInst extends BaseInst {

    private boolean noaliasFlag = false;

    public CallInst(Function callFunc, BasicBlock parentBlock, ArrayList<BaseValue> callArgs) {
        super(callFunc.name + LLVMTable.CallSuffix,
                ((IRFuncType) callFunc.type).retType,
                parentBlock);
        this.addOperand(callFunc);
        for (int i = 0; i < callArgs.size(); i++) this.addOperand(callArgs.get(i));
    }

    public CallInst(Function callFunc, BasicBlock parentBlock, BaseValue... callArgs) {
        super(callFunc.name + LLVMTable.CallSuffix,
                ((IRFuncType) callFunc.type).retType,
                parentBlock);
        this.addOperand(callFunc);
        for (BaseValue arg : callArgs) this.addOperand(arg);
    }

    public Function callFunc() {
        return (Function) this.getOperand(0);
    }

    public BaseValue getArgs(int index) {
        return this.getOperand(index+1);
    }

    public CallInst noalias() {
        noaliasFlag = true;
        return this;
    }

    @Override
    public String format() {
        // %call = call i32 @foo(i32 1)
        StringBuilder ret = new StringBuilder((this.type.match(new VoidType())) ? "" : this.identifier() + " = ");
        ret.append(LLVMTable.CallInst + " ");
        if (noaliasFlag) ret.append("noalias ");
        ret.append(this.callFunc().typedIdentifier()).append("(");
        for (int i = 0; i < this.callFunc().getArgNum(); i++) {
            ret.append(this.callFunc().getArgType(i)).append(" ").append(this.getArgs(i).identifier());
            if (i != this.callFunc().getArgNum() - 1) ret.append(", ");
        }
        ret.append(")");
        return ret.toString();
    }
}
