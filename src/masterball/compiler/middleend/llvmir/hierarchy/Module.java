package masterball.compiler.middleend.llvmir.hierarchy;

import masterball.compiler.middleend.llvmir.IRTranslator;
import masterball.compiler.middleend.llvmir.constant.GlobalVariable;
import masterball.compiler.middleend.llvmir.constant.StringConst;
import masterball.compiler.utils.LLVMTable;
import masterball.compiler.utils.error.runtime.UnknownError;

import java.util.ArrayList;
import java.util.Objects;

public class Module {
    public ArrayList<Function> functions = new ArrayList<>();
    public ArrayList<Function> methods = new ArrayList<>();
    public ArrayList<Function> builtinFunctions = new ArrayList<>();
    public ArrayList<StructProto> classes = new ArrayList<>();

    // static data segment
    public ArrayList<GlobalVariable> globalVarSeg = new ArrayList<>();
    public ArrayList<StringConst> stringConstSeg = new ArrayList<>();

    public void setBottomFunctions() {
        builtinFunctions.add(new Function(LLVMTable.BottomPrefix + "malloc",
                IRTranslator.heapPointerType, IRTranslator.i32Type));

        builtinFunctions.add(new Function(LLVMTable.BottomStrFuncPrefix + LLVMTable.StrCatArg,
                IRTranslator.stringType, IRTranslator.stringType, IRTranslator.stringType));

        builtinFunctions.add(new Function(LLVMTable.BottomStrFuncPrefix + LLVMTable.EqualArg,
                IRTranslator.boolType, IRTranslator.stringType, IRTranslator.stringType));

        builtinFunctions.add(new Function(LLVMTable.BottomStrFuncPrefix + LLVMTable.NotEqualArg,
                IRTranslator.boolType, IRTranslator.stringType, IRTranslator.stringType));

        builtinFunctions.add(new Function(LLVMTable.BottomStrFuncPrefix + LLVMTable.LessArg,
                IRTranslator.boolType, IRTranslator.stringType, IRTranslator.stringType));

        builtinFunctions.add(new Function(LLVMTable.BottomStrFuncPrefix + LLVMTable.LessEqualArg,
                IRTranslator.boolType, IRTranslator.stringType, IRTranslator.stringType));

        builtinFunctions.add(new Function(LLVMTable.BottomStrFuncPrefix + LLVMTable.GreaterArg,
                IRTranslator.boolType, IRTranslator.stringType, IRTranslator.stringType));

        builtinFunctions.add(new Function(LLVMTable.BottomStrFuncPrefix + LLVMTable.GreaterEqualArg,
                IRTranslator.boolType, IRTranslator.stringType, IRTranslator.stringType));
    }

    public Function getMalloc() {
        return builtinFunctions.get(0);
    }

    public Function getStrMethod(String op) {
        for (Function builtinFunction : builtinFunctions) {
            if (Objects.equals(builtinFunction.name, LLVMTable.BottomStrFuncPrefix + op))
                return builtinFunction;
        }
        throw new UnknownError(op);
    }

    public StringConst getStringConst(String constData) {
        for (StringConst stringConst : stringConstSeg) {
            if (Objects.equals(stringConst.constData, constData))
                return stringConst;
        }

        StringConst stringConst = new StringConst(constData);
        stringConstSeg.add(stringConst);
        return stringConst;
    }
}
