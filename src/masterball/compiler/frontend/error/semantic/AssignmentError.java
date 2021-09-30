package masterball.compiler.frontend.error.semantic;

import masterball.compiler.frontend.error.SemanticError;
import masterball.compiler.frontend.info.CodePos;

public class AssignmentError extends SemanticError {

    public static final String expectLeftValue = "the expression on the left side of the assign-op should be a left value";
    public AssignmentError(CodePos codePos, String message) {
        super(codePos, message, "AssignmentError");
    }
}
