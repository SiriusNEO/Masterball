package masterball.compiler.share.error;

import masterball.compiler.frontend.info.CodePos;

public class RuntimeError extends CompileError {
    public static String runtimeErrorHint = "[Runtime Error]: ";

    public RuntimeError(CodePos codePos, String message) {
        super(runtimeErrorHint + message + codePos);
    }

    // unable to target local
    public RuntimeError(String message) {
        super(runtimeErrorHint + message);
    }
}
