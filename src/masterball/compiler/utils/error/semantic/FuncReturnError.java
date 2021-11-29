package masterball.compiler.utils.error.semantic;

import masterball.compiler.utils.error.SemanticError;
import masterball.compiler.frontend.info.CodePos;

public class FuncReturnError extends SemanticError {

    public static final String noReturn = "no return statement in the function body";
    public static final String retTypeNotMatch = "wrong return type";

    public FuncReturnError(CodePos codePos, String message) {
        super(codePos, message, "FuncReturnError");
    }
}
