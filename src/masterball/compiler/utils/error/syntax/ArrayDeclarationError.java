package masterball.compiler.utils.error.syntax;

import masterball.compiler.utils.error.SyntaxError;
import masterball.compiler.frontend.info.CodePos;

public class ArrayDeclarationError extends SyntaxError {

    public static final String outsizeFirst = "the size of outer dimension should be declared first";
    public static final String leastOneSize  = "at least you should declare one outer size";

    public ArrayDeclarationError(CodePos codePos, String message) {
        super(codePos, message, "ArrayDeclarationError");
    }
}
