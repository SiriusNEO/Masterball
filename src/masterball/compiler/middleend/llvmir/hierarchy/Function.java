package masterball.compiler.middleend.llvmir.hierarchy;

import masterball.compiler.middleend.llvmir.constant.GlobalValue;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.middleend.llvmir.type.IRFuncType;
import masterball.compiler.utils.LLVMTable;

import java.util.ArrayList;

public class Function extends GlobalValue {
    public final ArrayList<BasicBlock> blocks = new ArrayList<BasicBlock>();

    public Function(String name, IRFuncType funcType) {
        // not init complete.
        // finished in IRBuilder

        super(name, funcType);
        new BasicBlock(LLVMTable.EntryBlockLabel, this);
        new BasicBlock(LLVMTable.ExitBlockLabel, this);
        this.entryBlock().parentFunction = this;
        this.exitBlock().parentFunction = this;
    }

    // bottom function decl
    public Function(String name, IRBaseType retType, IRBaseType... argTypes) {
        super(name, new IRFuncType(retType, null));
        for (IRBaseType argType : argTypes) ((IRFuncType) this.type).argTypes.add(argType);
    }

    public void addArg(BaseValue arg) {
        this.addOperand(arg);
    }

    public int getArgNum() {return ((IRFuncType) this.type).argTypes.size();}

    public IRBaseType getArgType(int index) {
        return ((IRFuncType) this.type).argTypes.get(index);
    }

    public BasicBlock entryBlock() {return blocks.get(0);}
    public BasicBlock exitBlock() {return blocks.get(1);}
}
