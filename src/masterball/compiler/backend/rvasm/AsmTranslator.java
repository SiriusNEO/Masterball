package masterball.compiler.backend.rvasm;

import masterball.compiler.share.lang.LLVM;
import masterball.compiler.share.lang.RV32I;
import masterball.compiler.share.misc.Pair;

public class AsmTranslator {

    public static String translateByteWidth(int byteWidth) {
        switch (byteWidth) {
            case 1: return RV32I.ByteKeyword;
            case 2: return RV32I.HalfWordKeyword;
            case 4: return RV32I.WordKeyword;
        }
        return "";
    }

    public static String translateArithmOp(String irOp) {
        switch (irOp) {
            case LLVM.DivInst: return RV32I.DivInst;
            case LLVM.ModInst: return RV32I.ModInst;
            case LLVM.ShiftLeftInst: return RV32I.ShiftLeftInst;
            case LLVM.ShiftRightInst: return RV32I.ShiftRightInst;
            // notice: LLVM IR and RV32 Asm have many in common
            default: return irOp;
        }
    }

    // second param: swap flag (e.g. a > b to b < a)
    public static Pair<String, Boolean> translateCmpOp(String irOp) {
        switch (irOp) {
            case LLVM.GreaterArg: return new Pair<>(RV32I.LessSuffix, true);
            case LLVM.GreaterEqualArg: return new Pair<>(RV32I.GreaterEqualSuffix, false);
            case LLVM.LessArg: return new Pair<>(RV32I.LessSuffix, false);
            case LLVM.LessEqualArg: return new Pair<>(RV32I.GreaterEqualSuffix, true);
            default: return new Pair<>(irOp, false);
        }
    }
}
