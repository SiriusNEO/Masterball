package masterball.compiler.middleend;

import masterball.compiler.middleend.llvmir.IRFormatter;
import masterball.compiler.middleend.llvmir.constant.GlobalVariable;
import masterball.compiler.middleend.llvmir.constant.StringConst;
import masterball.compiler.middleend.llvmir.hierarchy.*;
import masterball.compiler.middleend.llvmir.hierarchy.Module;
import masterball.compiler.middleend.llvmir.inst.BaseInst;
import masterball.debug.Log;

import java.io.OutputStream;
import java.io.PrintStream;

public class IRPrinter {

    public static final String INDENT = "  ";

    // based on hierarchy

    private final PrintStream ps;

    public IRPrinter() {
        this.ps = System.out;
    }

    public IRPrinter(PrintStream ps) {
        this.ps = ps;
    }

    public void printFunc(Function function) {
        ps.println(IRFormatter.funcDefFormat(function) + " {");
        printBlock(function.entryBlock());
        ps.print("\n");
        for (int i = 2; i < function.blocks.size(); i++) {
            printBlock(function.blocks.get(i));
            ps.print("\n");
        }
        printBlock(function.exitBlock());
        ps.println("}\n");
    }

    public void printBlock(BasicBlock block) {
        ps.println(block.name + ":");
        for (BaseInst inst : block.instructions) {
            ps.println(INDENT + IRFormatter.instFormat(inst));
        }
    }

    public void printModule(Module module) {
        Log.report("IR Printer Start Sucess");

        ps.println(TargetInfo.dataLayout);
        ps.println(TargetInfo.triple + "\n");

        for (Function func : module.builtinFunctions) {
            ps.println(IRFormatter.funcDeclFormat(func));
        }

        ps.print('\n');

        for (GlobalVariable globalVar : module.globalVarSeg) {
            ps.println(IRFormatter.globalVarInitFormat(globalVar));
        }

        if (module.globalVarSeg.size() > 0) ps.print('\n');

        for (StringConst stringConst : module.stringConstSeg) {
            ps.println(IRFormatter.stringConstInitFormat(stringConst));
        }

        if (module.stringConstSeg.size() > 0) ps.print('\n');

        for (StructProto structProto : module.classes) {
            ps.println(IRFormatter.classInitFormat(structProto));
        }

        if (module.classes.size() > 0) ps.print('\n');

        for (Function method : module.methods)
            printFunc(method);

        for (Function func : module.functions)
            printFunc(func);
    }

}
