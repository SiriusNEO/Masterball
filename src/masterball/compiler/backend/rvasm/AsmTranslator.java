package masterball.compiler.backend.rvasm;

import masterball.compiler.share.LLVMTable;
import masterball.compiler.share.RVTable;

public class AsmTranslator {

    public static String translateByteWidth(int byteWidth) {
        switch (byteWidth) {
            case 1: return RVTable.ByteKeyword;
            case 2: return RVTable.HalfWordKeyword;
            case 4: return RVTable.WordKeyword;
        }
        return "";
    }

    public static String translateOp(String IROp) {
        switch (IROp) {
            case LLVMTable.DivInst: return RVTable.DivInst;
            case LLVMTable.ModInst: return RVTable.ModInst;
            case LLVMTable.ShiftLeftInst: return RVTable.ShiftLeftInst;
            case LLVMTable.ShiftRightInst: return RVTable.ShiftRightInst;
            // notice: LLVM IR and RV32 Asm have many in common
            default: return IROp;
        }
    }
}
