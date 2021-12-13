package masterball.compiler.backend.rvasm;

import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.hierarchy.AsmModule;
import masterball.compiler.share.pass.AsmBlockPass;
import masterball.compiler.share.pass.AsmFuncPass;
import masterball.compiler.share.pass.AsmModulePass;
import masterball.debug.Log;

import java.io.PrintStream;

public class AsmPrinter implements AsmModulePass, AsmFuncPass, AsmBlockPass {

    public final static String TAB = "\t";

    public int funcEndCounter = 0;

    private final PrintStream ps;
    private final String irFilePath;

    public AsmPrinter(String irFilePath, PrintStream ps) {
        this.ps = ps;
        this.irFilePath = irFilePath;
    }

    @Override
    public void runOnModule(AsmModule module) {
        Log.report("Asm Printer Start Sucess");

        ps.println(TAB + ".text");
        ps.println(TAB + ".file" + TAB + irFilePath);
        module.functions.forEach(this::runOnFunc);
        module.globalVarSeg.forEach(globalVar -> {
            AsmFormatter.globalVariableFormat(globalVar).forEach(ps::println);
            ps.println();
        });
        module.stringConstSeg.forEach(stringConst -> {
            AsmFormatter.stringConstFormat(stringConst).forEach(ps::println);
            ps.println();
        });
    }

    @Override
    public void runOnFunc(AsmFunction function) {
        AsmFormatter.functionHeaderFormat(function).forEach(ps::println);
        ps.println(function.identifier + ":");
        // ps.println(TAB + ".cfi_startproc");
        function.blocks.forEach(this::runOnBlock);
        ps.println(".Lfunc_end" + funcEndCounter + ":");
        ps.println(TAB + ".size" + TAB + function + ", .Lfunc_end" + funcEndCounter + "-" + function);
        funcEndCounter++;
        // ps.println(TAB + ".cfi_endproc");
        ps.println("                                        # -- End function");
    }

    @Override
    public void runOnBlock(AsmBlock block) {
        ps.println(block.identifier + ":");
        block.instructions.forEach(inst -> ps.println(AsmFormatter.instFormat(inst)));
    }
}
