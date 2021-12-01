package masterball.compiler.middleend.llvmir.hierarchy;

import masterball.compiler.middleend.IRTranslator;
import masterball.compiler.middleend.llvmir.constant.GlobalVariable;
import masterball.compiler.middleend.llvmir.type.*;
import masterball.compiler.utils.LLVMTable;

import java.util.ArrayList;
import java.util.HashMap;

public class Module {
    public ArrayList<Function> functions = new ArrayList<>();
    public ArrayList<Function> builtinFunctions = new ArrayList<>();
    public ArrayList<GlobalVariable> globalVars = new ArrayList<>();
    public ArrayList<ClassType> classes = new ArrayList<>();

    public void bottomFunctions() {
        builtinFunctions.add(new Function("malloc", IRTranslator.stringType, IRTranslator.i32Type));

        builtinFunctions.add(new Function(LLVMTable.BottomStrFuncPrefix + "cat", IRTranslator.stringType,
                IRTranslator.stringType, IRTranslator.stringType));

        builtinFunctions.add(new Function(LLVMTable.BottomStrFuncPrefix + "eq", IRTranslator.boolType,
                IRTranslator.stringType, IRTranslator.stringType));

        builtinFunctions.add(new Function(LLVMTable.BottomStrFuncPrefix + "ne", IRTranslator.boolType,
                IRTranslator.stringType, IRTranslator.stringType));

        builtinFunctions.add(new Function(LLVMTable.BottomStrFuncPrefix + "slt", IRTranslator.boolType,
                IRTranslator.stringType, IRTranslator.stringType));

        builtinFunctions.add(new Function(LLVMTable.BottomStrFuncPrefix + "sle", IRTranslator.boolType,
                IRTranslator.stringType, IRTranslator.stringType));

        builtinFunctions.add(new Function(LLVMTable.BottomStrFuncPrefix + "sgt", IRTranslator.boolType,
                IRTranslator.stringType, IRTranslator.stringType));

        builtinFunctions.add(new Function(LLVMTable.BottomStrFuncPrefix + "sge", IRTranslator.boolType,
                IRTranslator.stringType, IRTranslator.stringType));
    }

    public Function getMalloc() {
        return builtinFunctions.get(0);
    }
}
