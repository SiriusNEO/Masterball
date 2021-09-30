package masterball.compiler.frontend.error.semantic;

import masterball.compiler.frontend.error.SemanticError;
import masterball.compiler.frontend.info.CodePos;

public class UndefinedBehaviourError extends SemanticError {
    public UndefinedBehaviourError(CodePos codePos, String message, String name) {
        super(codePos, message, name);
    }
}
