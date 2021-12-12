package masterball.compiler.backend.rvasm;

import masterball.compiler.backend.rvasm.AsmFormatter;
import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.hierarchy.AsmModule;
import masterball.compiler.share.pass.AsmBlockPass;
import masterball.compiler.share.pass.AsmFuncPass;
import masterball.compiler.share.pass.AsmModulePass;

import java.io.PrintStream;

public class AsmPrinter implements AsmModulePass, AsmFuncPass, AsmBlockPass {

    public final static String INDENT = "    ";

    private final PrintStream ps;

    public AsmPrinter() {
        this.ps = System.out;
    }

    public AsmPrinter(PrintStream ps) {
        this.ps = ps;
    }

    @Override
    public void runOnModule(AsmModule module) {
        ps.println(INDENT + ".text");
        module.functions.forEach(this::runOnFunc);
    }

    @Override
    public void runOnFunc(AsmFunction function) {
        AsmFormatter.functionHeaderFormat(function).forEach(info -> ps.println(INDENT + info));
        function.blocks.forEach(this::runOnBlock);
        AsmFormatter.functionTailFormat(function).forEach(info -> ps.println(INDENT + info));
    }

    @Override
    public void runOnBlock(AsmBlock block) {
        ps.println(block.identifier + ":");
        block.instructions.forEach(inst -> ps.println(INDENT + AsmFormatter.instFormat(inst)));
    }
}
