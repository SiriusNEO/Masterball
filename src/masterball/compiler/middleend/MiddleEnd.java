package masterball.compiler.middleend;

import masterball.compiler.frontend.FrontEnd;
import masterball.compiler.middleend.llvmir.IRBuilder;
import masterball.compiler.middleend.llvmir.IRPrinter;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;
import masterball.compiler.middleend.optim.MiddleEndOptimizer;
import masterball.console.Console;
import masterball.debug.Log;

public class MiddleEnd {

    public final IRModule irModule;

    public MiddleEnd(FrontEnd frontEnd, Console console) {
        // rename flag. can be set to false for debug purpose
        Value.rename = true;

        // IR Builder
        this.irModule = new IRBuilder(frontEnd.ASTRoot).module;

        // Optimize IR. Don't comment it directly because there are some necessary passes.
        new MiddleEndOptimizer().runOnModule(this.irModule);

        // IR Printer
        new IRPrinter(Console.getFileName(console.inputPath), console.irOutputStream).runOnModule(this.irModule);

        Log.track("MiddleEnd started successfully.");
    }

}
