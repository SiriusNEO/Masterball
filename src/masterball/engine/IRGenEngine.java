package masterball.engine;

import masterball.compiler.middleend.llvmir.IRBuilder;
import masterball.compiler.middleend.llvmir.IRPrinter;
import masterball.compiler.middleend.ssa.SSADestructor;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;
import masterball.debug.Log;

import java.io.PrintStream;

public class IRGenEngine {

    public final IRModule module;

    public IRGenEngine(SemanticEngine se, IOEngine ioEngine) {
        // rename flag. can be set to false for debug purpose
        Value.rename = true;

        this.module = new IRBuilder(se.ASTRoot).module;

        if (ioEngine != null) {
            new IRPrinter(IOEngine.getFileName(ioEngine.inputPath), ioEngine.irGenStream).runOnModule(this.module);
        }

        this.module.functions.forEach(func -> new SSADestructor().runOnFunc(func));

        Log.track("IRGenEngine started successfully.");
    }
}
