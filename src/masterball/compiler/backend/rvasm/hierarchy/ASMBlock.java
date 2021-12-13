package masterball.compiler.backend.rvasm.hierarchy;

import masterball.compiler.backend.rvasm.inst.AsmBaseInst;
import masterball.compiler.backend.rvasm.operand.BaseOperand;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;

import java.util.HashSet;
import java.util.LinkedList;

public class AsmBlock extends BaseOperand {

    public LinkedList<AsmBaseInst> instructions = new LinkedList<>();
    public HashSet<AsmBlock> prevs = new HashSet<>(), nexts = new HashSet<>();

    public AsmBlock(String label) {
        super(label);
    }

    public void addInst(AsmBaseInst inst) {
        instructions.add(inst);
    }
}
