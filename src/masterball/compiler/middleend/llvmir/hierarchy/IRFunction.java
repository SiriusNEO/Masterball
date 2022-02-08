package masterball.compiler.middleend.llvmir.hierarchy;

import masterball.compiler.middleend.analyzer.CallAnalyzer;
import masterball.compiler.middleend.llvmir.IRTranslator;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.constant.GlobalValue;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.middleend.llvmir.type.IRFuncType;
import masterball.compiler.share.lang.LLVM;

import java.util.ArrayList;

public class IRFunction extends GlobalValue {
    public final ArrayList<IRBlock> blocks = new ArrayList<>();

    public IRBlock entryBlock, exitBlock;

    // info in CallGraph
    public CallAnalyzer.Node node = new CallAnalyzer.Node(this);

    public IRFunction(String name, IRFuncType funcType) {
        // not init complete.
        // finished in IRBuilder

        super(name, funcType);
        entryBlock = new IRBlock(LLVM.EntryBlockLabel, this);
        exitBlock = new IRBlock(LLVM.ExitBlockLabel, this);
        entryBlock.parentFunction = this;

        // remember: here we place exit in second, not the logic order
        exitBlock.parentFunction = this;
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

    public int getArgNum() {return ((IRFuncType) this.type).argTypes.size();}

    public IRBaseType getArgType(int index) {
        return ((IRFuncType) this.type).argTypes.get(index);
    }
}
