package masterball.compiler.middleend.llvmir;

import masterball.compiler.frontend.info.scope.GlobalScope;
import masterball.compiler.frontend.info.type.MxBaseType;
import masterball.compiler.frontend.info.type.MxFuncType;
import masterball.compiler.frontend.info.type.VarType;
import masterball.compiler.middleend.llvmir.type.*;
import masterball.compiler.share.lang.LLVM;
import masterball.compiler.share.lang.MxStar;

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
            case MxStar.AddOp: return LLVM.AddInst;
            case MxStar.SubOp: return LLVM.SubInst;
            case MxStar.MulOp: return LLVM.MulInst;
            case MxStar.DivOp: return LLVM.DivInst;
            case MxStar.ModOp: return LLVM.ModInst;
            case MxStar.ArithShiftLeftOp: return LLVM.ShiftLeftInst;
            case MxStar.ArithShiftRightOp: return LLVM.ShiftRightInst;
            case MxStar.BitAndOp: return LLVM.AndInst;
            case MxStar.BitOrOp: return LLVM.OrInst;
            case MxStar.BitXorOp: return LLVM.XorInst;
            case MxStar.GreaterOp: return LLVM.GreaterArg;
            case MxStar.GreaterEqualOp: return LLVM.GreaterEqualArg;
            case MxStar.LessOp: return LLVM.LessArg;
            case MxStar.LessEqualOp: return LLVM.LessEqualArg;
            case MxStar.EqualOp: return LLVM.EqualArg;
            case MxStar.NotEqualOp: return LLVM.NotEqualArg;
        }
        return "";
    }

    public static String translateStrOp(String mxOp) {
        // add -> cat, others (cmp op) are the same
        if (Objects.equals(mxOp, MxStar.AddOp)) return LLVM.StrCatArg;
        return translateOp(mxOp);
    }

    // to translate types, you must instantiate a Translator to support translate CLASS
    private GlobalScope globalScope;

    public void setGlobalScope(GlobalScope globalScope) {this.globalScope = globalScope;}

    public IRBaseType translateBuiltinType(MxBaseType mxType) {
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
