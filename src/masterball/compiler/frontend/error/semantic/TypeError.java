package masterball.compiler.frontend.error.semantic;

import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.error.SemanticError;
import masterball.compiler.frontend.info.Type;

public class TypeError extends SemanticError {

    public static final String typeNotMatch = "type mismatched between: ";
    public static final String typeNotSubscribable = "type not subscribable: ";

    public TypeError(CodePos codePos, Type lhs, Type rhs) {
        super(codePos, typeNotMatch + "\"" +  lhs + "\" and \"" + rhs + "\"", "TypeError");
    }

    public TypeError(CodePos codePos, Type lhs, Type.BasicType rhs) {
        super(codePos, typeNotMatch + "\"" + lhs + "\" and \"" + rhs + "\"", "TypeError");
    }

    public TypeError(CodePos codePos, Type type) {
        super(codePos, typeNotSubscribable + type, "TypeError");
    }
}
