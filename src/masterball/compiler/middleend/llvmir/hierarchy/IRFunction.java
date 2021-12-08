package masterball.compiler.middleend.llvmir.hierarchy;

import masterball.compiler.middleend.llvmir.constant.GlobalValue;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.middleend.llvmir.type.IRFuncType;
import masterball.compiler.share.LLVMTable;

import java.util.ArrayList;

public class IRFunction extends GlobalValue {
    public final ArrayList<IRBlock> blocks = new ArrayList<IRBlock>();

    public IRFunction(String name, IRFuncType funcType) {
        // not init complete.
        // finished in IRBuilder

        super(name, funcType);
        new IRBlock(LLVMTable.EntryBlockLabel, this);
        new IRBlock(LLVMTable.ExitBlockLabel, this);
        this.entryBlock().parentFunction = this;
        this.exitBlock().parentFunction = this;
    }

    // bottom function decl
    public IRFunction(String name, IRBaseType retType, IRBaseType... argTypes) {
        super(name, new IRFuncType(retType, null));
        for (IRBaseType argType : argTypes) ((IRFuncType) this.type).argTypes.add(argType);
    }

    public void addArg(Value arg) {
        this.addOperand(arg);
    }

    public int getArgNum() {return ((IRFuncType) this.type).argTypes.size();}

    public IRBaseType getArgType(int index) {
        return ((IRFuncType) this.type).argTypes.get(index);
    }

    public IRBlock entryBlock() {return blocks.get(0);}
    public IRBlock exitBlock() {return blocks.get(1);}
}
