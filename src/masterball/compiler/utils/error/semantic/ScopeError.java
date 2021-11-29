package masterball.compiler.utils.error.semantic;

import masterball.compiler.utils.error.SemanticError;
import masterball.compiler.frontend.info.CodePos;

public class ScopeError extends SemanticError {

    public static final String wrongBreak = "\"break\" not in a loop-statement";
    public static final String wrongContinue = "\"continue\" not in a loop-statement";
    public static final String wrongReturn = "\"return\" not in a function body";
    public static final String wrongThis = "\"this\" not in a class body";

    public ScopeError(CodePos codePos, String message) {
        super(codePos, message, "ScopeError");
    }
}
