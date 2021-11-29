package masterball.compiler.utils.error;

import masterball.compiler.frontend.info.CodePos;

public class BaseError extends RuntimeException {
    public CodePos codePos;
    public String message;

    public BaseError(CodePos codePos, String message) {
        this.codePos = codePos;
        this.message = message;
    }

    public void tell() {System.err.println(message);}
}
