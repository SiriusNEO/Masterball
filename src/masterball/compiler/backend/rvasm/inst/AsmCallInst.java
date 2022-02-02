package masterball.compiler.backend.rvasm.inst;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.operand.PhysicalReg;
import masterball.compiler.backend.rvasm.operand.Register;
import masterball.compiler.share.lang.RV32I;
import masterball.debug.Log;

import java.util.HashSet;

public class AsmCallInst extends AsmBaseInst {
    private final AsmFunction calledFunc;

    public AsmCallInst(AsmFunction calledFunc, AsmBlock parentBlock) {
        super(null, null, null, null, parentBlock);
        this.calledFunc = calledFunc;
    }

    @Override
    public HashSet<Register> uses() {
        HashSet<Register> ret = new HashSet<>();
        for (int i = 0; i < Integer.min(RV32I.MaxArgRegNum, calledFunc.arguments.size()); i++)
            ret.add(PhysicalReg.a(i));
        return ret;
    }

    @Override
    public HashSet<Register> defs() {
        return new HashSet<>(PhysicalReg.callerSaved);
    }

    @Override
    public String format() {
        // call symbol
        return String.format("%s\t%s", RV32I.CallInst, calledFunc.identifier);
    }
}
