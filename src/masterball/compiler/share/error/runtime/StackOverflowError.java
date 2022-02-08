package masterball.compiler.share.error.runtime;

import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.share.error.RuntimeError;

public class StackOverflowError extends RuntimeError {
    public StackOverflowError() {
        super("STACK OVERFLOW!");
    }
}
