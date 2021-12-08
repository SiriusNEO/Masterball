package masterball.compiler.backend.rvasm.hierarchy;

import masterball.compiler.backend.rvasm.inst.AsmBaseInst;

import java.util.LinkedList;

public class ASMBlock {

    public LinkedList<AsmBaseInst> instructions;

    public void addInst(AsmBaseInst inst) {
        instructions.add(inst);
    }

}
