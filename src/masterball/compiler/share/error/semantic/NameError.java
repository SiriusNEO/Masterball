package masterball.compiler.share.error.semantic;

import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.share.error.SemanticError;

public class NameError extends SemanticError {

    public static final String undefined = "undefined";
    public static final String redefined = "redefined";

    public NameError(CodePos codePos, String message, String nameMsg) {
        super(codePos, "\"" + nameMsg + "\" " + message, "NameError");
    }
}
