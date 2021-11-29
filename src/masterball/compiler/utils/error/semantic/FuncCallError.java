package masterball.compiler.utils.error.semantic;

import masterball.compiler.utils.error.SemanticError;
import masterball.compiler.frontend.info.CodePos;

public class FuncCallError extends SemanticError {

    public static final String argcNotMatch = "wrong number of arguments for the function call";
    public static final String argTypeNotMatch = "wrong type of argument for the function call";
    public static final String expNotAFunc = "the expression is not a function";

    public FuncCallError(CodePos codePos, String message) {
        super(codePos, message, "FuncCallError");
    }
}
