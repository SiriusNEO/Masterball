package masterball.compiler.frontend.error.syntax;

import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.error.SyntaxError;

public class MainFuncError extends SyntaxError {

    public static final String missingMain = "missing valid \"main\" function";

    public MainFuncError(CodePos codePos, String message) {
        super(codePos, message, "MainFunc Error");
    }
}
