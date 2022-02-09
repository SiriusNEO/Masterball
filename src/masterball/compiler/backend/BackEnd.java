package masterball.compiler.backend;

import masterball.compiler.backend.optim.BackEndOptimizer;
import masterball.compiler.backend.regalloc.RegisterAllocator;
import masterball.compiler.backend.regalloc.StackAllocator;
import masterball.compiler.backend.rvasm.AsmBuilder;
import masterball.compiler.backend.rvasm.AsmPrinter;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.hierarchy.AsmModule;
import masterball.compiler.middleend.MiddleEnd;
import masterball.console.Config;
import masterball.debug.Log;
import masterball.console.Console;

import java.io.PrintStream;
import java.util.ArrayList;

public class BackEnd {

    public final AsmModule module;

    public final ArrayList<AsmFunction> functions = new ArrayList<>();

    public BackEnd(MiddleEnd middleEnd, Console console) {
        // Assembly Builder
        this.module = new AsmBuilder(middleEnd.irModule).module;

        // Graph Coloring
        new RegisterAllocator().runOnModule(this.module);

        // Stack Allocate. Eliminate RawStackOffset
        new StackAllocator().runOnModule(this.module);

        // Optimize Assembly. Don't comment it directly because there are some necessary passes.
        new BackEndOptimizer().runOnModule(this.module);

        if (console.canPrintASM) {
            // ASM Printer
            new AsmPrinter(
                    Console.getFileName(Config.getPath(Config.Option.ASMOutput)),
                    (PrintStream) Config.getArgValue(Config.Option.ASMOutput)
            ).runOnModule(this.module);
        }

        Log.track("BackEnd started successfully.");
    }
}