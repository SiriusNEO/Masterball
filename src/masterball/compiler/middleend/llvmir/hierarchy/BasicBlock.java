package masterball.compiler.middleend.llvmir.hierarchy;

import masterball.compiler.middleend.llvmir.inst.BaseInst;
import masterball.compiler.middleend.llvmir.type.LabelType;

import java.util.LinkedList;

// BasicBlock is also a Value

public class BasicBlock extends BaseValue {
    public LinkedList<BaseInst> instructions = new LinkedList<>();

    public Function parentFunction;

    public BasicBlock(String label) {
        super(label, new LabelType());
    }

    public void addInst(BaseInst inst) {
        instructions.addLast(inst);
    }
}
