package masterball.compiler.share.error.runtime;

import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.share.error.RuntimeError;

public class InternalError extends RuntimeError {
    public static final String internal = "InternalError happened. ";

    public InternalError(String msg) {
        super(internal + msg);
    }
}
