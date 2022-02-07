package masterball.compiler.backend.rvasm.inst;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.operand.Immediate;
import masterball.compiler.backend.rvasm.operand.Register;
import masterball.compiler.middleend.llvmir.Value;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;

public abstract class AsmBaseInst {
    public Register rd, rs1, rs2;
    public Immediate imm;

    // the parentBlock will be "null" if this instruction will be inserted to a specific position
    public AsmBaseInst(Register rd, Register rs1, Register rs2, Immediate imm, AsmBlock parentBlock) {
        this.rd = rd;
        this.rs1 = rs1;
        this.rs2 = rs2;
        this.imm = imm;
        if (parentBlock != null) parentBlock.addInst(this);
    }

    public void replaceUse(Register oldUse, Register newUse) {
        if (rs1 == oldUse) rs1 = newUse;
        if (rs2 == oldUse) rs2 = newUse;
    }

    public void replaceDef(Register oldDef, Register newDef) {
        if (rd == oldDef) {
            rd = newDef;
        }
    }

    public HashSet<Register> uses() {
        HashSet<Register> ret = new HashSet<>();
        if (rs1 != null) ret.add(rs1);
        if (rs2 != null) ret.add(rs2);
        return ret;
    }

    public HashSet<Register> defs() {
        HashSet<Register> ret = new HashSet<>();
        if (rd != null) ret.add(rd);
        return ret;
    }

    public abstract String format();

}
