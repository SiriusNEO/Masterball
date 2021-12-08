package masterball.compiler.backend.rvasm;

import masterball.compiler.backend.rvasm.hierarchy.ASMBlock;
import masterball.compiler.backend.rvasm.hierarchy.ASMFunction;
import masterball.compiler.backend.rvasm.operand.Immediate;
import masterball.compiler.backend.rvasm.operand.Register;
import masterball.compiler.middleend.llvmir.hierarchy.Value;

public class AsmCurrent {

    public ASMBlock block;
    public ASMFunction func;

    public Register regGen(Value value) {
        return new Register();
    }

    public Immediate immGen(Value value) {
        return new Immediate();
    }

}
