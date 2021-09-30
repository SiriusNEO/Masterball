package masterball.compiler.frontend.error.syntax;

import masterball.compiler.frontend.error.SyntaxError;
import masterball.compiler.frontend.info.CodePos;

public class AssignmentError extends SyntaxError {

    public static final String expectLeftValue = "the expression on the left side of the assign-op should be a left value";
    public AssignmentError(CodePos codePos, String message) {
        super(codePos, message, "AssignmentError");
    }
}
