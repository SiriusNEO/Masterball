package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.BaseValue;
import masterball.compiler.middleend.llvmir.hierarchy.BasicBlock;
import masterball.compiler.middleend.llvmir.hierarchy.Function;
import masterball.compiler.middleend.llvmir.type.BaseType;
import masterball.compiler.utils.LLVMTable;

import java.util.ArrayList;

public class CallInst extends BaseInst {

    public CallInst(Function callFunc, ArrayList<BaseValue> callArgs, BasicBlock parentBlock) {
        super(callFunc.name + LLVMTable.CallSuffix, callFunc.type, parentBlock);
        this.addOperand(callFunc);
        for (int i = 0; i < callArgs.size(); i++) this.addOperand(callArgs.get(i));
    }

    public Function callFunc() {
        return (Function) this.getOperand(0);
    }

    public BaseValue getArgs(int index) {
        return this.getOperand(index+1);
    }
}
