package masterball.compiler.middleend.llvmir;

import masterball.compiler.middleend.llvmir.constant.GlobalVariable;
import masterball.compiler.middleend.llvmir.constant.StringConst;
import masterball.compiler.middleend.llvmir.hierarchy.*;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;
import masterball.compiler.middleend.llvmir.inst.IRBaseInst;
import masterball.compiler.share.pass.IRBlockPass;
import masterball.compiler.share.pass.IRFuncPass;
import masterball.compiler.share.pass.IRModulePass;
import masterball.debug.Log;

import java.io.PrintStream;

public class IRPrinter implements IRModulePass, IRFuncPass, IRBlockPass {

    public static final String INDENT = "  ";

    // based on hierarchy

    private final PrintStream ps;
    private final String mxFilePath;

    public IRPrinter(String mxFilePath, PrintStream ps) {
        this.ps = ps;
        this.mxFilePath = mxFilePath;
    }

    @Override
    public void runOnFunc(IRFunction function) {
        ps.println(IRFormatter.funcDefFormat(function) + " {");
        runOnBlock(function.entryBlock());
        ps.print("\n");
        for (int i = 2; i < function.blocks.size(); i++) {
            runOnBlock(function.blocks.get(i));
            ps.print("\n");
        }
        runOnBlock(function.exitBlock());
        ps.println("}\n");
    }

    @Override
    public void runOnBlock(IRBlock block) {
        block.setComment();
        ps.println(block.name + ":" + block.commentFormat());
        for (IRBaseInst inst : block.phiInsts) {
            ps.println(INDENT + IRFormatter.instFormat(inst));
        }
        for (IRBaseInst inst : block.instructions) {
            ps.println(INDENT + IRFormatter.instFormat(inst));
        }
    }

    @Override
    public void runOnModule(IRModule module) {
        Log.report("IR Printer Start Sucess");

        ps.printf("; ModuleID = '%s'%n", mxFilePath);
        ps.printf("source_filename = \"%s\"%n", mxFilePath);
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
        for (IRFunction func : module.functions) runOnFunc(func);
    }

}
