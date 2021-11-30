package masterball.compiler.middleend;

import masterball.compiler.middleend.llvmir.constant.GlobalVariable;
import masterball.compiler.middleend.llvmir.hierarchy.BaseValue;
import masterball.compiler.middleend.llvmir.hierarchy.Function;
import masterball.compiler.middleend.llvmir.inst.*;
import masterball.compiler.middleend.llvmir.type.VoidType;
import masterball.compiler.utils.LLVMTable;
import masterball.debug.Log;

// Formatter is a powerful tool in formatting one-line LLVM IR grammar
// To link them up, please see @IRPrinter

public class IRFormatter {

    // global variable initial format
    public static String globalVarInitialFormat(GlobalVariable globalVar) {
        return globalVar.identifier() + " = global " + globalVar.type;
    }

    public static String funcDeclFormat(Function function) {
        return "";
    }

    public static String funcDefFormat(Function function) {
        // define i32 @foo(i32 %a, i64 %b)
        StringBuilder ret = new StringBuilder("define " + function.typedIdentifier() + "(");
        for (int i = 0; i < function.operands.size(); i++) {
            ret.append(function.getOperand(i).type).append(" ").append(function.getOperand(i).identifier());
            if (i != function.operands.size() - 1) ret.append(", ");
        }
        ret.append(")");
        return ret.toString();
    }

    // instruction format
    public static String instFormat(BaseInst inst) {
        if (inst instanceof AllocaInst) {
            // %alloca = alloca <type>, align <size>
            return inst.identifier() + " = " + LLVMTable.AllocaInst + ", align " + inst.type.size();
        } else if (inst instanceof BinaryInst) {
            //%add = add i32 %A, %B
            return inst.identifier() + " = " + ((BinaryInst) inst).op + " " + inst.type + " " +
                    ((BinaryInst) inst).lhs().identifier() + ", " + ((BinaryInst) inst).rhs().identifier();
        } else if (inst instanceof BrInst) {
            // br i1 %comparison_result, label %A, label %B
            // br label %A
            if (!((BrInst) inst).isJump()) {
                return LLVMTable.BrInst + " " + ((BrInst) inst).condition().type + " " + ((BrInst) inst).condition().identifier()
                        + ", " + ((BrInst) inst).ifTrueBlock().typedIdentifier()
                        + ", " + ((BrInst) inst).ifFalseBlock().typedIdentifier();
            }
            else {
                return LLVMTable.BrInst + " " + ((BrInst) inst).destBlock().typedIdentifier();
            }
        } else if (inst instanceof CallInst) {
            // %call = call i32 @foo(i32 1)
            String ret = (inst.type.match(new VoidType())) ? "" : inst.identifier() + " = ";
            ret += LLVMTable.CallInst + " " +((CallInst) inst).callFunc().typedIdentifier();
            ret += "(";
            for (int i = 0; i < ((CallInst) inst).callFunc().getArgNum(); i++) {
                ret += ((CallInst) inst).getArgs(i).typedIdentifier();
                if (i != ((CallInst) inst).callFunc().getArgNum() - 1) ret += ", ";
            }
            ret += ")";
            return ret;
        } else if (inst instanceof ICmpInst) {
            //%cmp = icmp slt i32 %i_value, 4
            return inst.identifier() + " = " + LLVMTable.ICmpInst + " " +
                    ((ICmpInst) inst).op + " " + ((ICmpInst) inst).lhs().typedIdentifier()+ ", " + ((ICmpInst) inst).rhs().identifier();
        } else if (inst instanceof LoadInst) {
            // %load = load <type>, <type*> %destPtr, align <size>
            return inst.identifier() + " = " + LLVMTable.LoadInst + " " + inst.type + ", " +
                    ((LoadInst) inst).destPtr().typedIdentifier() + ", align " +
                    inst.type.size();
        } else if (inst instanceof RetInst) {
            // ret i32 0
            // ret void
            String ret = LLVMTable.RetInst + " " + inst.type;
            if (!inst.type.match(new VoidType()))
                ret += " " + ((RetInst) inst).retVal().identifier();
            return ret;
        } else if (inst instanceof StoreInst) {
            // store i32 %1, i32* %i
            return LLVMTable.StoreInst + " " +
                    ((StoreInst) inst).storeValue().typedIdentifier() + ", " +
                    ((StoreInst) inst).destPtr().typedIdentifier();
        }
        return "";
    }

}
