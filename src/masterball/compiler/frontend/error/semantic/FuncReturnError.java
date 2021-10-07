package masterball.compiler.frontend.error.semantic;

import masterball.compiler.frontend.error.SemanticError;
import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.info.type.BaseType;

public class FuncReturnError extends SemanticError {

    public static final String noReturn = "no return statement in the function body";
    public static final String retTypeNotMatch = "wrong return type";

    public FuncReturnError(CodePos codePos, String message) {
        super(codePos, message, "FuncReturnError");
    }
}
