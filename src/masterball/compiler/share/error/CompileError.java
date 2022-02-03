package masterball.compiler.share.error;

public class CompileError extends RuntimeException {
    public String message;

    public CompileError(String message) {
        this.message = message;
    }

    public void tell() {System.err.println("<masterball compiler>: " + message);}
}
