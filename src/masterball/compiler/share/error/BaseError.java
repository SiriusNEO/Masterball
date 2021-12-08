package masterball.compiler.share.error;

public class BaseError extends RuntimeException {
    public String message;

    public BaseError(String message) {
        this.message = message;
    }

    public void tell() {System.err.println(message);}
}
