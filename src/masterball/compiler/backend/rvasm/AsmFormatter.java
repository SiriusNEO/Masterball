package masterball.compiler.backend.rvasm;

import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.inst.AsmBaseInst;

import java.util.ArrayList;

public class AsmFormatter {

    public static String TAB = "\t";

    public static ArrayList<String> functionHeaderFormat(AsmFunction function) {
        ArrayList<String> ret = new ArrayList<>();
        ret.add(".globl" + TAB + function);
        ret.add(".p2align" + TAB + "1");
        ret.add(".type" + TAB + function + "," + "@function");
        return ret;
    }

    public static ArrayList<String> functionTailFormat(AsmFunction function) {
        ArrayList<String> ret = new ArrayList<>();
        ret.add(".size" + TAB + function + ", ,-" + function);
        return ret;
    }

    public static String instFormat(AsmBaseInst inst) {
        return inst.format();
    }
}
