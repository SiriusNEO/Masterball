package masterball.compiler.frontend.error.semantic;

import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.error.SemanticError;
import masterball.compiler.frontend.info.type.BaseType;

public class TypeError extends SemanticError {

    public static final String typeNotMatch = "type mismatched between: ";
    public static final String typeNotSubscribable = "type not subscribable: ";
    public static final String typeNotCallable = "type not callable: ";

    public TypeError(CodePos codePos, BaseType lhs, BaseType rhs) {
        super(codePos, typeNotMatch + "\"" +  lhs + "\" and \"" + rhs + "\"", "TypeError");
    }

    public TypeError(CodePos codePos, BaseType.BuiltinType lhs, BaseType rhs) {
        super(codePos, typeNotMatch + "\"" + lhs + "\" and \"" + rhs + "\"", "TypeError");
    }

    public TypeError(CodePos codePos, String message, BaseType type) {
        super(codePos, message + type, "TypeError");
    }
}
