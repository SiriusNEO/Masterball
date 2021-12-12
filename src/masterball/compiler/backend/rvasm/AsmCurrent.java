package masterball.compiler.backend.rvasm;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.inst.*;
import masterball.compiler.backend.rvasm.operand.Immediate;
import masterball.compiler.backend.rvasm.operand.PhysicalReg;
import masterball.compiler.backend.rvasm.operand.Register;
import masterball.compiler.backend.rvasm.operand.VirtualReg;
import masterball.compiler.middleend.llvmir.constant.BoolConst;
import masterball.compiler.middleend.llvmir.constant.IntConst;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.share.lang.RV32I;
import masterball.compiler.share.error.runtime.UnimplementedError;
import masterball.compiler.share.error.runtime.UnknownError;

public class AsmCurrent {

    public AsmBlock block;
    public AsmFunction func;

    public Register toReg(Value value) {
        if (value.asmOperand != null)
            return (Register) value.asmOperand;

        VirtualReg ret = new VirtualReg(value.type.size());
        Integer intValue = null;
        if (value instanceof IntConst) intValue = ((IntConst) value).constData;
        else if (value instanceof BoolConst) intValue = ((BoolConst) value).constData ? 1 : 0;
        if (intValue != null && intValue == 0) {
            value.asmOperand = PhysicalReg.reg("zero");
            return PhysicalReg.reg("zero");
        }
        else if (intValue != null) {
            new AsmLiInst(ret, new Immediate(intValue), this.block);
        }
        value.asmOperand = ret;
        return ret;
    }

    public Immediate toImm(int value) {
        if (value < -1 * RV32I.ImmBound || value > RV32I.ImmBound) throw new UnknownError(this);
        return new Immediate(value);
    }

    public Immediate toImm(Value value) {
        if (value instanceof IntConst) return new Immediate(((IntConst) value).constData);
        if (value instanceof BoolConst) return new Immediate (((BoolConst) value).constData ? 1 : 0);
        throw new UnimplementedError(this);
    }
}
