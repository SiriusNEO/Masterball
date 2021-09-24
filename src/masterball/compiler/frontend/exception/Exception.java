package masterball.compiler.frontend.exception;

public abstract class Exception extends RuntimeException {
    public CodePos codePos;
    public String message;

    public Exception(CodePos codePos) {
        this.codePos = codePos;
        this.message = noExceptionHint;
    }

    public abstract String getMessage();

    public static String noExceptionHint = "[NoException]";
    public static String syntaxExceptionHint = "[Syntax Exception]: ";
    public static String semanticExceptionHint = "[Semantic Exception]: ";
}
