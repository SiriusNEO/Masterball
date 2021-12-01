package masterball.compiler.middleend.llvmir.hierarchy;

import masterball.compiler.middleend.llvmir.inst.BaseInst;
import masterball.compiler.middleend.llvmir.inst.BrInst;
import masterball.compiler.middleend.llvmir.inst.RetInst;
import masterball.compiler.middleend.llvmir.type.LabelType;
import masterball.compiler.utils.LLVMTable;
import masterball.compiler.utils.error.RuntimeError;
import masterball.debug.Log;

import java.util.LinkedList;

// BasicBlock is also a Value

public class BasicBlock extends BaseValue {
    public LinkedList<BaseInst> instructions = new LinkedList<>();

    public Function parentFunction;

    public boolean isTerminated = false;

    public BasicBlock(String label, Function parentFunction) {
        super(parentFunction.name + LLVMTable.Spliter + label, new LabelType());
        this.parentFunction = parentFunction;
        parentFunction.blocks.add(this);
    }

    public void addInst(BaseInst inst) {
        if (isTerminated) return;
        instructions.addLast(inst);
        if (inst.isTerminator()) isTerminated = true;
    }
}
