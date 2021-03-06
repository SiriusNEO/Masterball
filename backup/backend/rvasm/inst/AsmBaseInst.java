package masterball.compiler.backend.rvasm.inst;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.operand.Immediate;
import masterball.compiler.backend.rvasm.operand.Register;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;

public abstract class AsmBaseInst {
    public Register rd, rs1, rs2;
    public Immediate imm;
    public HashSet<Register> uses = new HashSet<>(), defs = new HashSet<>();

    // the parentBlock will be "null" if this instruction will be inserted to a specific position
    public AsmBaseInst(Register rd, Register rs1, Register rs2, Immediate imm, AsmBlock parentBlock) {
        this.rd = rd;
        this.rs1 = rs1;
        this.rs2 = rs2;
        this.imm = imm;
        if (parentBlock != null) parentBlock.addInst(this);
        if (rd != null) defs.add(rd);
        if (rs1 != null) uses.add(rs1);
        if (rs2 != null) uses.add(rs2);
    }

    public void replaceUse(Register oldUse, Register newUse) {
        if (rs1 == oldUse) {
            uses.remove(rs1);
            rs1 = newUse;
            uses.add(rs1);
        }
        if (rs2 == oldUse) {
            uses.remove(rs2);
            rs2 = newUse;
            uses.add(rs2);
        }
    }

    public void replaceDef(Register oldDef, Register newDef) {
        if (rd == oldDef) {
            defs.remove(rd);
            rd = newDef;
            defs.add(rd);
        }
        else {
            throw new UnknownError();
        }
    }

    public abstract String format();

}
