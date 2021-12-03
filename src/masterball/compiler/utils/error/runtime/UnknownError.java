package masterball.compiler.utils.error.runtime;

import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.utils.error.RuntimeError;

import java.util.Objects;

public class UnknownError extends RuntimeError {
    public static final String unknown = "UnknownError happened. Related class: ";

    public UnknownError(CodePos codePos, Object obj) {
        super(codePos, unknown + obj.getClass().getName());
    }

    public UnknownError(Object obj) {
        super(unknown + obj.getClass().getName());
    }
}
