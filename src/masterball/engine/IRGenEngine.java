package masterball.engine;

import masterball.compiler.middleend.llvmir.IRBuilder;
import masterball.compiler.middleend.llvmir.IRPrinter;
import masterball.compiler.middleend.ssa.SSADestructor;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;

import java.io.PrintStream;

public class IRGenEngine {

    public final IRModule module;

    public IRGenEngine(SemanticEngine se, boolean renameFlag, PrintStream irGenStream) {
        Value.rename = renameFlag;
        this.module = new IRBuilder(se.ASTRoot).module;

        if (irGenStream != null) {
            new IRPrinter(irGenStream).runOnModule(this.module);
        }

        this.module.functions.forEach(func -> new SSADestructor().runOnFunc(func));
    }
}
