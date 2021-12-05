package masterball.compiler.middleend.llvmir;

import masterball.compiler.middleend.llvmir.constant.GlobalVariable;
import masterball.compiler.middleend.llvmir.constant.StringConst;
import masterball.compiler.middleend.llvmir.hierarchy.Function;
import masterball.compiler.middleend.llvmir.hierarchy.StructProto;
import masterball.compiler.middleend.llvmir.inst.*;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.middleend.llvmir.type.IRFuncType;
import masterball.compiler.middleend.llvmir.type.PointerType;
import masterball.compiler.middleend.llvmir.type.StructType;

// Formatter is a powerful tool in formatting one-line LLVM IR grammar
// To link them up, please see @IRPrinter

public class IRFormatter {

    public static String stringConstInitFormat(StringConst stringConst) {
        return stringConst.identifier() + " = private unnamed_addr constant " + ((PointerType) stringConst.type).pointedType + " "
                + stringConst.constDataFormat() + ", align " + ((PointerType) stringConst.type).pointedType.size();
    }

    public static String globalVarInitFormat(GlobalVariable globalVar) {
        return globalVar.identifier() + " = global " + globalVar.pointedType() + " zeroinitializer, align " + globalVar.pointedType().size();
    }

    public static String classInitFormat(StructProto structProto) {
        StringBuilder ret = new StringBuilder(structProto.identifier() + " = type {");
        for (int i = 0; i < structProto.struct().memberVarTypes.size(); i++) {
            ret.append(structProto.struct().memberVarTypes.get(i));
            if (i != structProto.struct().memberVarTypes.size() - 1) ret.append(", ");
        }
        ret.append("}");
        return ret.toString();
    }

    public static String funcDeclFormat(Function function) {
        // declare void @print(i8*)
        StringBuilder ret = new StringBuilder("declare " + function.typedIdentifier() + "(");
        for (int i = 0; i < ((IRFuncType) function.type).argTypes.size(); i++) {
            ret.append(((IRFuncType) function.type).argTypes.get(i));
            if (i != ((IRFuncType) function.type).argTypes.size() - 1) ret.append(", ");
        }
        ret.append(")");
        return ret.toString();
    }

    public static String funcDefFormat(Function function) {
        // define i32 @foo(i32 %a, i64 %b)
        StringBuilder ret = new StringBuilder("define " + function.typedIdentifier() + "(");
        for (int i = 0; i < function.operands.size(); i++) {
            ret.append(function.getOperand(i).typedIdentifier());
            if (i != function.operands.size() - 1) ret.append(", ");
        }
        ret.append(")");
        return ret.toString();
    }

    // instruction format
    public static String instFormat(BaseInst inst) {
        // every instruction override method "format"
        return inst.format();
    }

}
