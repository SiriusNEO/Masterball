package masterball.compiler.frontend.exception;

public class SyntaxException extends Exception {

    public SyntaxException(CodePos codePos) {
        super(codePos);
    }

    @Override
    public String getMessage() {
        return syntaxExceptionHint + message + codePos;
    }
}
