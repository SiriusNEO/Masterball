package masterball.compiler.middleend.llvmir;

import masterball.compiler.frontend.info.scope.GlobalScope;
import masterball.compiler.frontend.info.type.MxBaseType;
import masterball.compiler.frontend.info.type.MxFuncType;
import masterball.compiler.frontend.info.type.VarType;
import masterball.compiler.middleend.llvmir.type.*;
import masterball.compiler.share.LLVMTable;
import masterball.compiler.share.MxStarTable;

import java.util.Objects;

public class IRTranslator {
    public static final IRBaseType stringType = new PointerType(new IntType(8)),
            boolType = new BoolType(),
            memBoolType = new MemBoolType(),
            i32Type = new IntType(32),
            voidType = new VoidType(),
            heapPointerType = new PointerType(new IntType(8)),
            nullType = heapPointerType,
            i32PointerType = new PointerType(i32Type);

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

    // to translate types, you must instantiate a Translator to support translate CLASS
    private GlobalScope globalScope;

    public void setGlobalScope(GlobalScope globalScope) {this.globalScope = globalScope;}

    public IRBaseType translateBuiltinType(MxBaseType mxType) {
        // TODO: not implemented completely yet
        IRBaseType ret;
        switch (mxType.builtinType) {
            case INT: ret = i32Type; break;
            case BOOL: ret = boolType; break;
            case STRING: ret = stringType; break;
            case CLASS: ret = new PointerType(globalScope.queryClass(((VarType) mxType).className).value.type); break;
            default: ret = voidType;
        }
        return ret;
    }

    public IRFuncType translateFuncType(MxFuncType funcType, IRBaseType methodFrom) {
        IRFuncType ret = new IRFuncType(translateVarType(funcType.retType), methodFrom);

        if (methodFrom != null) ret.argTypes.add(methodFrom);

        for (MxBaseType argType : funcType.funcArgsType)
            ret.argTypes.add(translateVarType(argType));
        return ret;
    }

    public IRBaseType translateVarType(MxBaseType mxType) {
        IRBaseType ret;

        // VarType: (builtin type/class name), with dimension (array)
        assert mxType instanceof VarType;

        ret = translateBuiltinType(mxType);

        // array: recursive pointer-wrapped
        for (int i = 1; i <= ((VarType) mxType).dimension; i++)
            ret = new PointerType(ret);

        return ret;
    }

    public IRBaseType translateAllocaType(MxBaseType mxType) {
        IRBaseType ret;
        if (mxType.builtinType == MxBaseType.BuiltinType.BOOL)
            ret = memBoolType;
        else return translateVarType(mxType);
        for (int i = 1; i <= ((VarType) mxType).dimension; i++)
            ret = new PointerType(ret);

        return ret;
    }
}
