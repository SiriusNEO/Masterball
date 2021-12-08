package masterball.compiler.share.error.syntax;

import masterball.compiler.share.error.SyntaxError;
import masterball.compiler.frontend.info.CodePos;

public class ClassDeclarationError extends SyntaxError {
    public static final String constructorWrongName = "the name of constructor should be consistent with class";

    public ClassDeclarationError(CodePos codePos, String message) {
        super(codePos, message, "ClassDeclarationError");
    }
}
