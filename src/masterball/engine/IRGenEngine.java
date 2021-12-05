package masterball.engine;

import masterball.compiler.middleend.IRBuilder;
import masterball.compiler.middleend.IRPrinter;
import masterball.compiler.middleend.llvmir.hierarchy.BaseValue;
import masterball.compiler.middleend.llvmir.hierarchy.Module;
import masterball.compiler.middleend.llvmir.inst.BaseInst;

import java.io.PrintStream;

public class IRGenEngine {

    public final Module module;

    public IRGenEngine(SemanticEngine se, boolean renameFlag, PrintStream irGenStream) {
        BaseValue.rename = renameFlag;
        this.module = new IRBuilder(se.ASTRoot).module;
        if (irGenStream != null) {
            new IRPrinter(irGenStream).printModule(this.module);
        }
    }
}
