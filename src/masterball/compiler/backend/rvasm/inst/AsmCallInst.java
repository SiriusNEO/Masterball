package masterball.compiler.backend.rvasm.inst;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.operand.PhysicalReg;
import masterball.compiler.share.lang.RV32I;
import masterball.debug.Log;

public class AsmCallInst extends AsmBaseInst {
    private final AsmFunction calledFunc;

    public AsmCallInst(AsmFunction calledFunc, AsmBlock parentBlock) {
        super(null, null, null, null, parentBlock);
        this.calledFunc = calledFunc;

        for (int i = 0; i < Integer.min(RV32I.MaxArgRegNum, calledFunc.arguments.size()); i++)
            this.uses.add(PhysicalReg.a(i));

        this.defs.addAll(PhysicalReg.callerSaved);
    }

    @Override
    public String format() {
        // call symbol
        return String.format("%s\t%s", RV32I.CallInst, calledFunc.identifier);
    }
}
