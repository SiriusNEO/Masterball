package masterball.compiler.middleend.llvmir.hierarchy;

import masterball.compiler.frontend.info.registry.FuncRegistry;
import masterball.compiler.middleend.llvmir.constant.GlobalValue;
import masterball.compiler.middleend.llvmir.type.BaseType;
import masterball.compiler.utils.LLVMTable;

import java.util.ArrayList;

public class Function extends GlobalValue {
    public ArrayList<BasicBlock> blocks = new ArrayList<BasicBlock>();

    public Function(String name, BaseType type) {
        // not init complete.
        // finished in IRBuilder

        super(name, type);
        this.blocks.add(new BasicBlock(LLVMTable.EntryBlockLabel));
        this.blocks.add(new BasicBlock(LLVMTable.ExitBlockLabel));
        this.entryBlock().parentFunction = this;
        this.exitBlock().parentFunction = this;
    }

    public BasicBlock entryBlock() {return blocks.get(0);}
    public BasicBlock exitBlock() {return blocks.get(1);}
}
