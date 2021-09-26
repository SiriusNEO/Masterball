package masterball.compiler.frontend.error.semantic;

import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.error.SemanticError;

public class NameReDefined extends SemanticError {

    public NameReDefined(CodePos codePos, String name) {
        super(codePos, "\"" + name + "\" redefined", "NameReDefined");
    }
}