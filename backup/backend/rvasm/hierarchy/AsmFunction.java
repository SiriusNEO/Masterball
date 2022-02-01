package masterball.compiler.backend.rvasm.hierarchy;

import masterball.compiler.backend.rvasm.operand.BaseOperand;
import masterball.compiler.backend.rvasm.operand.Register;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;

import java.util.ArrayList;

public class AsmFunction extends BaseOperand {

    public final ArrayList<AsmBlock> blocks = new ArrayList<>();
    public final ArrayList<Register> arguments = new ArrayList<>();

    public int callStackUse = 0, allocaStackUse = 0, virtualStackUse = 0, totalStackUse = 0;

    public AsmFunction(String identifier) {
        super(identifier);
    }

    public AsmBlock entryBlock() {return blocks.get(0);}
    public AsmBlock exitBlock() {return blocks.get(1);}
}
