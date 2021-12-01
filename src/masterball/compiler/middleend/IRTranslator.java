package masterball.compiler.middleend;

import masterball.compiler.frontend.info.type.VarType;
import masterball.compiler.middleend.llvmir.type.*;
import masterball.compiler.utils.LLVMTable;
import masterball.compiler.utils.MxStarTable;
import masterball.debug.Log;

public class IRTranslator {
    public static final BaseType stringType = new PointerType(new IntType(8)),
            boolType = new BoolType(),
            i32Type = new IntType(32);

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
            case MxStarTable.GreaterOp: return LLVMTable.GreaterArg;
            case MxStarTable.GreaterEqualOp: return LLVMTable.GreaterEqualArg;
            case MxStarTable.LessOp: return LLVMTable.LessArg;
            case MxStarTable.LessEqualOp: return LLVMTable.LessEqualArg;
            case MxStarTable.EqualOp: return LLVMTable.EqualArg;
            case MxStarTable.NotEqualOp: return LLVMTable.NotEqualArg;
        }
        return "";
    }

    public static BaseType translateType(masterball.compiler.frontend.info.type.BaseType mxType) {
        // TODO: not implemented yet

        BaseType ret = null;

        if (mxType instanceof VarType) {
            if (((VarType) mxType).dimension == 0) {
                switch (mxType.builtinType) {
                    case INT: ret = i32Type; break;
                    case BOOL: ret = boolType; break;
                    case STRING: ret = stringType; break;
                    default: ret = new VoidType();
                }
            }
        }
        return ret;
    }
}
