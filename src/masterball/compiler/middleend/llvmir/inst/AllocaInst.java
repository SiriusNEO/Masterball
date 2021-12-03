package masterball.compiler.middleend.llvmir.inst;

import masterball.compiler.middleend.llvmir.hierarchy.BasicBlock;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.middleend.llvmir.type.PointerType;
import masterball.compiler.utils.LLVMTable;

public class AllocaInst extends BaseInst {
    public IRBaseType allocaType;

    public AllocaInst(String allocaName, IRBaseType allocaType, BasicBlock parentBlock) {
        super(addrRename(allocaName),
              new PointerType(allocaType), parentBlock);

        this.allocaType = allocaType;
    }

    @Override
    public String format() {
        // %alloca = alloca <type>, align <size>
        return this.identifier() + " = " + LLVMTable.AllocaInst + " " +
                this.allocaType + ", align " + this.allocaType.size();
    }
}
