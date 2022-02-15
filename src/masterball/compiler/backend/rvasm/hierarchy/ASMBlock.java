package masterball.compiler.backend.rvasm.hierarchy;

import masterball.compiler.backend.rvasm.inst.AsmBaseInst;
import masterball.compiler.backend.rvasm.operand.BaseOperand;
import masterball.compiler.backend.rvasm.operand.Register;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.inst.IRBaseInst;
import masterball.compiler.share.error.runtime.InternalError;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class AsmBlock extends BaseOperand {

    public LinkedList<AsmBaseInst> instructions = new LinkedList<>();

    // control flow graph
    public ArrayList<AsmBlock> prevs = new ArrayList<>(), nexts = new ArrayList<>();

    // liveIn and LiveOut in block, assigned in LivenessAnalyzer
    public HashSet<Register> liveIn = new HashSet<>(), liveOut = new HashSet<>();

    public AsmBlock(String label) {
        super(label);
    }

    public void addInst(AsmBaseInst inst) {
        instructions.add(inst);
    }

    public AsmBaseInst terminator() {
        if (instructions.isEmpty()) throw new InternalError("empty AsmBLock! no terminator! " + this.identifier);
        return instructions.getLast();
    }
}
