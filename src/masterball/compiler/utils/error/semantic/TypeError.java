package masterball.compiler.utils.error.semantic;

import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.utils.error.SemanticError;
import masterball.compiler.frontend.info.type.BaseType;

public class TypeError extends SemanticError {

    public static final String typeNotMatch = "type mismatched between: ";
    public static final String typeNotSubscribable = "type not subscribable: ";
    public static final String typeNotCallable = "type not callable: ";
    public static final String canNotBeVoid = "\"void\" type can only use in function return type";

    public static final String invalidOpForType = "invalid operation for type: ";

    public static final String assignment = "the expression on the left side of the assign-op should be a left-value";
    public static final String prefixAndPostfix = "expecting a left-value in prefix/postfix expression";

    public TypeError(CodePos codePos, BaseType lhs, BaseType rhs) {
        super(codePos, typeNotMatch + "\"" +  lhs + "\" and \"" + rhs + "\"", "TypeError");
    }

    public TypeError(CodePos codePos, BaseType.BuiltinType lhs, BaseType rhs) {
        super(codePos, typeNotMatch + "\"" + lhs + "\" and \"" + rhs + "\"", "TypeError");
    }

    public TypeError(CodePos codePos, String message, BaseType type) {
        super(codePos, message + type, "TypeError");
    }

    public TypeError(CodePos codePos, String message) {
        super(codePos, message, "TypeError");
    }
}
