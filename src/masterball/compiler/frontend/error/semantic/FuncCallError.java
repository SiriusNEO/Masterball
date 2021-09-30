package masterball.compiler.frontend.error.semantic;

import masterball.compiler.frontend.error.SemanticError;
import masterball.compiler.frontend.info.CodePos;

public class FuncCallError extends SemanticError {

    public static final String argcNotMatch = "wrong number of arguments for the function call";
    public static final String argTypeNotMatch = "wrong type of argument for the function call";

    public FuncCallError(CodePos codePos, String message, String nameMsg) {
        super(codePos, message + " \"" + nameMsg + "\"", "FuncCallError");
    }
}
