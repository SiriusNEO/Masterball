package masterball.compiler.utils.error;

import masterball.compiler.frontend.info.CodePos;

public class RuntimeError extends BaseError {
    public RuntimeError(CodePos codePos, String message) {
        super(codePos, message);
    }
}
