package masterball.compiler.middleend;

import masterball.compiler.middleend.llvmir.IRFormatter;
import masterball.compiler.middleend.llvmir.IRVisitor;
import masterball.compiler.middleend.llvmir.constant.GlobalVariable;
import masterball.compiler.middleend.llvmir.constant.StringConst;
import masterball.compiler.middleend.llvmir.hierarchy.*;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;
import masterball.compiler.middleend.llvmir.inst.IRBaseInst;
import masterball.debug.Log;

import java.io.PrintStream;

public class IRPrinter implements IRVisitor {

    public static final String INDENT = "  ";

    // based on hierarchy

    private final PrintStream ps;

    public IRPrinter() {
        this.ps = System.out;
    }

    public IRPrinter(PrintStream ps) {
        this.ps = ps;
    }

    @Override
    public void visit(IRFunction function) {
        ps.println(IRFormatter.funcDefFormat(function) + " {");
        visit(function.entryBlock());
        ps.print("\n");
        for (int i = 2; i < function.blocks.size(); i++) {
            visit(function.blocks.get(i));
            ps.print("\n");
        }
        visit(function.exitBlock());
        ps.println("}\n");
    }

    @Override
    public void visit(IRBlock block) {
        block.setComment();
        ps.println(block.name + ":" + block.commentFormat());
        for (IRBaseInst inst : block.instructions) {
            ps.println(INDENT + IRFormatter.instFormat(inst));
        }
    }

    @Override
    public void visit(IRModule module) {
        Log.report("IR Printer Start Sucess");

        ps.println(TargetInfo.dataLayout);
        ps.println(TargetInfo.triple + "\n");

        for (IRFunction func : module.builtinFunctions) ps.println(IRFormatter.funcDeclFormat(func));
        ps.print('\n');

        for (GlobalVariable globalVar : module.globalVarSeg) ps.println(IRFormatter.globalVarInitFormat(globalVar));
        if (module.globalVarSeg.size() > 0) ps.print('\n');

        for (StringConst stringConst : module.stringConstSeg) ps.println(IRFormatter.stringConstInitFormat(stringConst));
        if (module.stringConstSeg.size() > 0) ps.print('\n');

        for (StructProto structProto : module.classes) ps.println(IRFormatter.classInitFormat(structProto));

        if (module.classes.size() > 0) ps.print('\n');
        for (IRFunction method : module.methods) visit(method);
        for (IRFunction func : module.functions) visit(func);
    }

}
