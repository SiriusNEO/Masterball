package masterball.compiler.share.warn;

import masterball.compiler.share.error.RuntimeError;

public class ZeroDivisionWarning extends Warning {
    public ZeroDivisionWarning() {
        super("integer division or modulo by zero");
    }
}
