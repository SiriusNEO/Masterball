package masterball.compiler.share.error;

import masterball.compiler.frontend.info.CodePos;

public class SemanticError extends CompileError {

    public static String semanticErrorHint = "[Semantic Error]: ";

    public SemanticError(CodePos codePos, String message, String name) {
        super(semanticErrorHint + "<" + name + "> " + message + codePos);
    }
}
