package masterball.compiler.share.error.syntax;

import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.share.error.SyntaxError;

public class MainFuncError extends SyntaxError {

    public static final String missingMain = "missing valid \"main\" function";

    public MainFuncError(CodePos codePos, String message) {
        super(codePos, message, "MainFunc Error");
    }
}
