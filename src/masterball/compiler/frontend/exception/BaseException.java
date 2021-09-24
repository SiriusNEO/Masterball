package masterball.compiler.frontend.exception;

public abstract class BaseException extends RuntimeException {
    public CodePos codePos;
    public String message;

    public BaseException(CodePos codePos, String message) {
        this.codePos = codePos;
        this.message = message;
    }

    public abstract String getMessage();
    public void tell() {System.err.println(this.getMessage());}

    public static String syntaxExceptionHint = "[Syntax Exception]: ";
    public static String semanticExceptionHint = "[Semantic Exception]: ";
}
