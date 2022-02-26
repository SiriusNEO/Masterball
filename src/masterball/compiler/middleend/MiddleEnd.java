package masterball.compiler.middleend;

import masterball.compiler.frontend.FrontEnd;
import masterball.compiler.middleend.analyzer.GPMark;
import masterball.compiler.middleend.llvmir.IRBuilder;
import masterball.compiler.middleend.llvmir.IRPrinter;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;
import masterball.compiler.middleend.optim.MiddleEndOptimizer;
import masterball.console.Config;
import masterball.console.Console;
import masterball.debug.Log;

import java.io.PrintStream;

public class MiddleEnd {

    public final IRModule irModule;

    public MiddleEnd(FrontEnd frontEnd, Console console) {
        // rename flag. can be set to false for debug purpose
        Value.rename = true;

        // IR Builder
        this.irModule = new IRBuilder(frontEnd.ASTRoot).module;

        if (console.canPrintIR) {
            // IR Printer
            new IRPrinter(
                    Console.getFileName(Config.getPath(Config.Option.Input)),
                    (PrintStream) Config.getArgValue(Config.Option.IROutput)
            ).runOnModule(this.irModule);
        }

        // Optimize IR. Don't comment it directly because there are some necessary passes.
        new MiddleEndOptimizer().runOnModule(this.irModule);

        // this will analyze loop
        // new GPMark().runOnModule(this.irModule);

        irModule.functions.forEach(function -> function.blocks.forEach(block -> block.instructions.forEach(inst -> {
            assert !inst.isValueSelf() || inst.users.size() > 0;
        })));

        if (console.canPrintOpt) {
            // IR Printer (after optimized)
            new IRPrinter(
                    Console.getFileName(Config.getPath(Config.Option.Input)),
                    (PrintStream) Config.getArgValue(Config.Option.OptOutput)
            ).runOnModule(this.irModule);
        }

        Log.track("MiddleEnd started successfully.");
    }

}
