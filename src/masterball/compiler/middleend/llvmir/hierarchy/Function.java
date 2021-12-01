package masterball.compiler.middleend.llvmir.hierarchy;

import masterball.compiler.frontend.info.registry.FuncRegistry;
import masterball.compiler.middleend.llvmir.constant.GlobalValue;
import masterball.compiler.middleend.llvmir.type.BaseType;
import masterball.compiler.middleend.llvmir.type.FunctionType;
import masterball.compiler.utils.LLVMTable;

import java.util.ArrayList;

public class Function extends GlobalValue {
    public ArrayList<BasicBlock> blocks = new ArrayList<BasicBlock>();

    public Function(String name, BaseType retType) {
        // not init complete.
        // finished in IRBuilder

        super(name, new FunctionType(retType));
        new BasicBlock(LLVMTable.EntryBlockLabel, this);
        new BasicBlock(LLVMTable.ExitBlockLabel, this);
        this.entryBlock().parentFunction = this;
        this.exitBlock().parentFunction = this;
    }

    public Function(String name, BaseType retType, BaseType... argTypes) {
        super(name, new FunctionType(retType));
        for (BaseType argType : argTypes) this.addArgType(argType);
    }

    public void addArg(BaseValue arg) {
        this.addOperand(arg);
    }

    public void addArgType(BaseType argType) {
        ((FunctionType) this.type).argTypes.add(argType);
    }

    public int getArgNum() {return ((FunctionType) this.type).argTypes.size();}
    public BaseValue getArg(int index) {return this.getOperand(index);}

    public BasicBlock entryBlock() {return blocks.get(0);}
    public BasicBlock exitBlock() {return blocks.get(1);}
}
