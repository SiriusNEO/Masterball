package masterball.compiler.share.warn;

import masterball.compiler.share.error.RuntimeError;

public class ZeroDivisionWarning extends Warning {
    public static final String zeroDivision = "integer division or modulo by zero";

    public ZeroDivisionWarning() {
        super(zeroDivision);
    }
}
