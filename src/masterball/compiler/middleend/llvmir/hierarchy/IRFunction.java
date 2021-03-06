package masterball.compiler.middleend.llvmir.hierarchy;

import masterball.compiler.middleend.analyzer.CallGraphAnalyzer;
import masterball.compiler.middleend.llvmir.IRTranslator;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.constant.GlobalValue;
import masterball.compiler.middleend.llvmir.inst.IRCallInst;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.middleend.llvmir.type.IRFuncType;
import masterball.compiler.share.lang.LLVM;

import java.util.HashSet;
import java.util.LinkedList;

public class IRFunction extends GlobalValue {
    public IRModule parentModule;

    public final LinkedList<IRBlock> blocks = new LinkedList<>();

    public IRBlock entryBlock, exitBlock;

    public Value retValPtr;

    // info in CallGraph
    public CallGraphAnalyzer.Node node = new CallGraphAnalyzer.Node(this);

    // info in Loop
    public HashSet<Loop> topLevelLoops = new HashSet<>();

    public IRFunction(String name, IRFuncType funcType, IRModule parentModule) {
        // not init complete.
        // finished in IRBuilder

        super(name, funcType);
        entryBlock = new IRBlock(LLVM.EntryBlockLabel, this);
        exitBlock = new IRBlock(LLVM.ExitBlockLabel, this);
        entryBlock.parentFunction = this;

        // remember: here we place exit in second, not the logic order
        exitBlock.parentFunction = this;

        this.parentModule = parentModule;
    }

    // bottom function decl
    public IRFunction(String name, IRBaseType retType, IRBaseType... argTypes) {
        super(name, new IRFuncType(retType, null));
        for (IRBaseType argType : argTypes) ((IRFuncType) this.type).argTypes.add(argType);
    }

    public boolean isVoid() {
        return ((IRFuncType) this.type).retType.match(IRTranslator.voidType);
    }

    public void addArg(Value arg) {
        this.addOperand(arg);
    }

    public Value getArg(int index) {
        return this.getOperand(index);
    }

    public int getArgNum() {return ((IRFuncType) this.type).argTypes.size();}

    public IRBaseType getArgType(int index) {
        return ((IRFuncType) this.type).argTypes.get(index);
    }
}
