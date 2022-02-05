package masterball.compiler.backend.rvasm.hierarchy;

import masterball.compiler.backend.rvasm.operand.BaseOperand;
import masterball.compiler.backend.rvasm.operand.Register;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;

import java.util.ArrayList;

public class AsmFunction extends BaseOperand {

    public final ArrayList<AsmBlock> blocks = new ArrayList<>();
    public final ArrayList<Register> arguments = new ArrayList<>();

    public AsmBlock entryBlock, exitBlock;

    public int callerArgStackUse = 0,
               allocaStackUse = 0,
               spillStackUse = 0,
               calleeArgStackUse = 0,
               totalStackUse = 0;

    public AsmFunction(String identifier) {
        super(identifier);
    }
}
