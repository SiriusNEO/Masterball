package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.middleend.llvmir.type.PointerType;
import masterball.compiler.share.LLVMTable;

public class IRAllocaInst extends IRBaseInst {
    public IRBaseType allocaType;

    public IRAllocaInst(String allocaName, IRBaseType allocaType, IRBlock parentBlock) {
        super(addrRename(allocaName),
              new PointerType(allocaType), parentBlock, true);

        this.allocaType = allocaType;
    }

    @Override
    public String format() {
        // %alloca = alloca <type>, align <size>
        return this.identifier() + " = " + LLVMTable.AllocaInst + " " +
                this.allocaType + ", align " + this.allocaType.size();
    }
}
