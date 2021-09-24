package masterball.compiler.frontend.exception;

public class SyntaxException extends BaseException {

    public SyntaxException(CodePos codePos, String message) {
        super(codePos, message);
    }

    @Override
    public String getMessage() {
        return syntaxExceptionHint + message + codePos;
    }
}
