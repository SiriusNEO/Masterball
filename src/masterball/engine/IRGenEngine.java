package masterball.engine;

import masterball.compiler.middleend.IRBuilder;
import masterball.compiler.middleend.IRPrinter;
import masterball.compiler.middleend.SSADestructor;
import masterball.compiler.middleend.llvmir.hierarchy.Value;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;

import java.io.PrintStream;

public class IRGenEngine {

    public final IRModule module;

    public IRGenEngine(SemanticEngine se, boolean renameFlag, PrintStream irGenStream) {
        Value.rename = renameFlag;
        this.module = new IRBuilder(se.ASTRoot).module;

        this.module.functions.forEach(func -> new SSADestructor().pass(func));
        this.module.methods.forEach(method -> new SSADestructor().pass(method));

        if (irGenStream != null) {
            new IRPrinter(irGenStream).visit(this.module);
        }
    }
}
