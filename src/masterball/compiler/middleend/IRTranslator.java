package masterball.compiler.middleend;

import masterball.compiler.frontend.info.type.VarType;
import masterball.compiler.middleend.llvmir.type.BaseType;
import masterball.compiler.middleend.llvmir.type.BoolType;
import masterball.compiler.middleend.llvmir.type.IntType;
import masterball.compiler.middleend.llvmir.type.VoidType;
import masterball.compiler.utils.LLVMTable;
import masterball.compiler.utils.MxStarTable;
import masterball.debug.Log;

public class IRTranslator {
    public static String translateOp(String mxOp) {
        switch (mxOp) {
            case MxStarTable.AddOp: return LLVMTable.AddInst;
            case MxStarTable.SubOp: return LLVMTable.SubInst;
            case MxStarTable.MulOp: return LLVMTable.MulInst;
            case MxStarTable.DivOp: return LLVMTable.DivInst;
            case MxStarTable.ModOp: return LLVMTable.ModInst;
            case MxStarTable.ArithShiftLeftOp: return LLVMTable.ShiftLeftInst;
            case MxStarTable.ArithShiftRightOp: return LLVMTable.ShiftRightInst;
            case MxStarTable.BitAndOp: return LLVMTable.AndInst;
            case MxStarTable.BitOrOp: return LLVMTable.OrInst;
            case MxStarTable.BitXorOp: return LLVMTable.XorInst;
        }
        return "";
    }

    public static BaseType translateType(masterball.compiler.frontend.info.type.BaseType mxType) {
        // TODO: not implemented yet

        BaseType ret = null;

        if (mxType instanceof VarType) {
            if (((VarType) mxType).dimension == 0) {
                switch (mxType.builtinType) {
                    case INT: ret = new IntType(); break;
                    case BOOL: ret = new BoolType(); break;
                    default: ret = new VoidType();
                }
            }
        }
        return ret;
    }
}
