package masterball.compiler.utils.error;

import masterball.compiler.frontend.info.CodePos;

public class BaseError extends RuntimeException {
    public String message;

    public BaseError(String message) {
        this.message = message;
    }

    public void tell() {System.err.println(message);}
}
