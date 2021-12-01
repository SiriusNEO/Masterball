package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.BasicBlock;
import masterball.compiler.middleend.llvmir.type.BaseType;
import masterball.compiler.middleend.llvmir.type.PointerType;
import masterball.compiler.utils.LLVMTable;

public class AllocaInst extends BaseInst {
    public BaseType allocaType;

    public AllocaInst(String allocaName, BaseType allocaType, BasicBlock parentBlock) {
        super(addrRename(allocaName),
              new PointerType(allocaType), parentBlock);

        this.allocaType = allocaType;
    }
}
