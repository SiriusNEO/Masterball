package masterball.compiler.utils.error.syntax;

import masterball.compiler.utils.error.SyntaxError;
import masterball.compiler.frontend.info.CodePos;

public class ParseFailedError extends SyntaxError {
    public ParseFailedError(CodePos codePos, String message) {
        super(codePos, message, "ParseFailedError");
    }
}
