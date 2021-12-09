package masterball.compiler.backend.rvasm;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.inst.AsmLiInst;
import masterball.compiler.backend.rvasm.operand.Immediate;
import masterball.compiler.backend.rvasm.operand.Register;
import masterball.compiler.backend.rvasm.operand.VirtualReg;
import masterball.compiler.middleend.llvmir.constant.BoolConst;
import masterball.compiler.middleend.llvmir.constant.IntConst;
import masterball.compiler.middleend.llvmir.hierarchy.Value;
import masterball.compiler.share.error.runtime.UnimplementedError;

import java.util.HashMap;

public class AsmCurrent {

    public AsmBlock block;
    public AsmFunction func;

    private int virtualRegNum;

    // static data segment
    private HashMap<Integer, Register> loadedImmSeg = new HashMap<>();

    public Register regGen(Value value) {
        VirtualReg ret = new VirtualReg(virtualRegNum++);
        Integer intValue = null;
        if (value instanceof IntConst)
            intValue = ((IntConst) value).constData;
        else if (value instanceof BoolConst)
            intValue = ((BoolConst) value).constData ? 1 : 0;
        if (loadedImmSeg.containsKey(intValue)) return loadedImmSeg.get(intValue);
        else if (intValue != null) {
            new AsmLiInst(ret, new Immediate(intValue), this.block);
            loadedImmSeg.put(intValue, ret);
        }
        return ret;
    }

    public Immediate immGen(Value value) {
        if (value instanceof IntConst) return new Immediate(((IntConst) value).constData);
        if (value instanceof BoolConst) return new Immediate (((BoolConst) value).constData ? 1 : 0);
        throw new UnimplementedError(this);
    }
}
