package masterball.compiler.backend.rvasm.hierarchy;

import masterball.compiler.backend.rvasm.operand.GlobalReg;
import masterball.compiler.backend.rvasm.operand.VirtualReg;

import java.util.ArrayList;

public class AsmModule {

    public ArrayList<AsmFunction> functions = new ArrayList<>();
    public ArrayList<GlobalReg> globalVarSeg = new ArrayList<>();
    public ArrayList<GlobalReg> stringConstSeg = new ArrayList<>();
}
