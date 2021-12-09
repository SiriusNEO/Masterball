package masterball.compiler.backend.rvasm.hierarchy;

import masterball.compiler.backend.rvasm.inst.AsmBaseInst;
import masterball.compiler.backend.rvasm.operand.BaseOperand;

import java.util.LinkedList;

public class AsmBlock extends BaseOperand {

    public LinkedList<AsmBaseInst> instructions;

    public AsmBlock(String label) {
        super(label);
    }

    public void addInst(AsmBaseInst inst) {
        instructions.add(inst);
    }
}
