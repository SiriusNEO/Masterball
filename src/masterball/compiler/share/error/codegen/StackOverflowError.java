package masterball.compiler.share.error.codegen;

import masterball.compiler.share.error.CodegenError;

public class StackOverflowError extends CodegenError {
    public StackOverflowError() {
        super("STACK OVERFLOW!");
    }
}
