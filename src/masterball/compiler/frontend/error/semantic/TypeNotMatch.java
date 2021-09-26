package masterball.compiler.frontend.error.semantic;

import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.error.SemanticError;

public class TypeNotMatch extends SemanticError {
    public TypeNotMatch(CodePos codePos, String message) {
        super(codePos, message, "Type Error");
    }
}
