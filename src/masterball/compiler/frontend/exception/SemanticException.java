package masterball.compiler.frontend.exception;

public class SemanticException extends BaseException {

    public SemanticException(CodePos codePos, String message) {
        super(codePos, message);
    }

    @Override
    public String getMessage() {
        return semanticExceptionHint + message + codePos;
    }
}
