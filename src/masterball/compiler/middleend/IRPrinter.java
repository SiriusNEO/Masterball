package masterball.compiler.middleend;

import masterball.compiler.middleend.IRFormatter;
import masterball.compiler.middleend.llvmir.hierarchy.BasicBlock;
import masterball.compiler.middleend.llvmir.hierarchy.Function;
import masterball.compiler.middleend.llvmir.hierarchy.Module;
import masterball.compiler.middleend.llvmir.hierarchy.TargetInfo;
import masterball.compiler.middleend.llvmir.inst.BaseInst;
import masterball.debug.Log;

public class IRPrinter {

    public static final String INDENT = "  ";

    // based on hierarchy

    public static void printFunc(Function function) {
        System.out.println(IRFormatter.funcDefFormat(function) + " {");
        printBlock(function.entryBlock());
        for (int i = 2; i < function.blocks.size(); i++) {
            printBlock(function.blocks.get(i));
        }
        printBlock(function.exitBlock());
        System.out.println("}\n");
    }

    public static void printBlock(BasicBlock block) {
        System.out.println(block.name + ":");
        for (BaseInst inst : block.instructions) {
            System.out.println(INDENT + IRFormatter.instFormat(inst));
        }
    }

    public static void printModule(Module module) {
        Log.report("IR Printer Start Sucess");

        System.out.println(TargetInfo.dataLayout);
        System.out.println(TargetInfo.triple + "\n");

        for (Function func : module.builtinFunctions) {
            System.out.println(IRFormatter.funcDeclFormat(func));
        }
        System.out.print('\n');
        for (Function func : module.functions)
            printFunc(func);
    }

}
