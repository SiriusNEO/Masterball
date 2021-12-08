package masterball.compiler.share.error;

import masterball.compiler.frontend.info.CodePos;

public class SyntaxError extends BaseError {

    public static String syntaxErrorHint = "[Syntax Error]: ";

    public SyntaxError(CodePos codePos, String message, String name) {
        super(syntaxErrorHint + "<" + name + "> " + message + codePos);
    }
}
