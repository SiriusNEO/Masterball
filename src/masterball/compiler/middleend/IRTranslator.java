package masterball.compiler.middleend;

import masterball.compiler.frontend.info.type.MxBaseType;
import masterball.compiler.frontend.info.type.MxFuncType;
import masterball.compiler.frontend.info.type.VarType;
import masterball.compiler.middleend.llvmir.type.*;
import masterball.compiler.utils.LLVMTable;
import masterball.compiler.utils.MxStarTable;

import java.util.Objects;

public class IRTranslator {
    public static final IRBaseType stringType = new PointerType(new IntType(8)),
            boolType = new BoolType(),
            memBoolType = new MemBoolType(),
            i32Type = new IntType(32),
            voidType = new VoidType(),
            nullType = new PointerType(voidType),
            heapPointerType = new PointerType(new IntType(8));

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

    public static String translateStrOp(String mxOp) {
        // add -> cat, others (cmp op) are the same
        if (Objects.equals(mxOp, MxStarTable.AddOp)) return LLVMTable.StrCatArg;
        return translateOp(mxOp);
    }

    public static IRBaseType translateBuiltinType(MxBaseType.BuiltinType builtinType) {
        // TODO: not implemented completely yet
        IRBaseType ret;
        switch (builtinType) {
            case INT: ret = i32Type; break;
            case BOOL: ret = boolType; break;
            case STRING: ret = stringType; break;
            default: ret = voidType;
        }
        return ret;
    }

    public static IRFuncType translateFuncType(MxFuncType funcType, IRBaseType methodFrom) {
        IRFuncType ret = new IRFuncType(translateVarType(funcType.retType));

        if (methodFrom != null) ret.argTypes.add(new PointerType(methodFrom));

        for (MxBaseType argType : funcType.funcArgsType)
            ret.argTypes.add(translateVarType(argType));
        return ret;
    }

    public static IRBaseType translateVarType(MxBaseType mxType) {
        IRBaseType ret;

        // VarType: (builtin type/class name), with dimension (array)
        assert mxType instanceof VarType;

        ret = translateBuiltinType(mxType.builtinType);

        // array: recursive pointer-wrapped
        for (int i = 1; i <= ((VarType) mxType).dimension; i++)
            ret = new PointerType(ret);

        return ret;
    }
}
