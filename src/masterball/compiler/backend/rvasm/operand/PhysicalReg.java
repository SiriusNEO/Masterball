package masterball.compiler.backend.rvasm.operand;

import masterball.compiler.share.lang.RV32I;

import java.util.ArrayList;
import java.util.HashMap;

public class PhysicalReg extends Register {
    /*
     * RV32 Physical Reg Arch
     */
    public static final HashMap<String, PhysicalReg> phyRegs = new HashMap<>() {
        {
            RV32I.RV32Reg.forEach(regName -> put(regName, new PhysicalReg(regName)));}
    };

    public static PhysicalReg reg(String regName) {return phyRegs.get(regName);}
    public static PhysicalReg a(int index) {return phyRegs.get(RV32I.FuncArgRegPrefix + index);}
    public static PhysicalReg t(int index) {return phyRegs.get(RV32I.TempRegPrefix + index);}
    public static PhysicalReg s(int index) {return phyRegs.get(RV32I.SavedRegPrefix + index);}

    public static ArrayList<PhysicalReg> callerSave = new ArrayList<>();
    public static ArrayList<PhysicalReg> calleeSave = new ArrayList<>();
    public static ArrayList<PhysicalReg> assignable = new ArrayList<>();

    static {
        callerSave.add(reg("ra"));
        for (int i = 0; i <= 6; ++i) callerSave.add(t(i));
        for (int i = 0; i <= 7; ++i) calleeSave.add(a(i));

        for (int i = 0; i <= 11; ++i) calleeSave.add(s(i));

        assignable.addAll(callerSave);
        assignable.addAll(calleeSave);
    };

    public PhysicalReg(String identifier) {
        super(identifier);
    }
}
