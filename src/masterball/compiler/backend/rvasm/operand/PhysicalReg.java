package masterball.compiler.backend.rvasm.operand;

import masterball.compiler.share.RVTable;

import java.util.HashMap;
import java.util.Map;

public class PhysicalReg extends Register {
    /*
     * RV32 Physical Reg Arch
     */
    private static final HashMap<String, PhysicalReg> phyRegs = new HashMap<>() {
        {RVTable.RV32Reg.forEach(regName -> put(regName, new PhysicalReg(regName)));}
    };

    public static PhysicalReg reg(String regName) {return phyRegs.get(regName);}
    public static PhysicalReg argReg(int index) {return phyRegs.get(RVTable.FuncArgRegPrefix + index);}
    public static PhysicalReg savedReg(int index) {return phyRegs.get(RVTable.SavedRegPrefix + index);}

    public PhysicalReg(String identifier) {
        super(identifier);
    }
}
