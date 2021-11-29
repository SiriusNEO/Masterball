package masterball.compiler.utils.error.syntax;

import masterball.compiler.utils.error.SyntaxError;
import masterball.compiler.frontend.info.CodePos;

public class ArrayDeclarationError extends SyntaxError {

    public static final String outsizeFirst = "the size of outer dimension should be declared first";

    public ArrayDeclarationError(CodePos codePos, String message) {
        super(codePos, message, "ArrayDeclarationError");
    }
}
