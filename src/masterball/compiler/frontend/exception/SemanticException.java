package masterball.compiler.frontend.exception;

public class SemanticException extends Exception {

    public SemanticException(CodePos codePos) {
        super(codePos);
    }

    @Override
    public String getMessage() {
        return semanticExceptionHint + message + codePos;
    }
}
