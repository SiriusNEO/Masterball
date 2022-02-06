package masterball.compiler.share.error.runtime;

import masterball.compiler.share.error.RuntimeError;

public class ZeroDivisionWarning extends RuntimeError {
    public static final String zeroDivision = "integer division or modulo by zero";

    public ZeroDivisionWarning() {
        super(zeroDivision);
    }
}
