package masterball.compiler.share.error.runtime;

import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.share.error.RuntimeError;

public class UnimplementedError extends RuntimeError {
    public static final String unimplemented = "This syntax is unimplemented. Related class: ";

    public UnimplementedError(CodePos codePos, Object obj) {
        super(codePos, unimplemented + obj.getClass().getName());
    }

    public UnimplementedError(Object obj) {
        super(unimplemented + obj.getClass().getName());
    }
}
