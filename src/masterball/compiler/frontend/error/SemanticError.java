package masterball.compiler.frontend.error;

import masterball.compiler.frontend.info.CodePos;

public class SemanticError extends BaseError {

    public static String semanticErrorHint = "[Semantic Error]: ";

    public SemanticError(CodePos codePos, String message, String name) {
        super(codePos, semanticErrorHint + "<" + name + "> " + message + codePos);
    }
}
