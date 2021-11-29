package masterball.engine;

import masterball.compiler.middleend.IRBuilder;
import masterball.compiler.middleend.IRPrinter;
import masterball.compiler.middleend.llvmir.hierarchy.BaseValue;
import masterball.compiler.middleend.llvmir.hierarchy.Module;
import masterball.compiler.middleend.llvmir.inst.BaseInst;

public class IRGenEngine {

    public final Module module;

    public IRGenEngine(SemanticEngine se, boolean renameFlag, boolean IRPrintFlag) {
        BaseValue.rename = renameFlag;
        this.module = new IRBuilder(se.ASTRoot).module;
        if (IRPrintFlag) {
            IRPrinter.printModule(this.module);
        }
    }
}
