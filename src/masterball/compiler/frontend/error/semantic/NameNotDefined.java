package masterball.compiler.frontend.error.semantic;

import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.error.SemanticError;

public class NameNotDefined extends SemanticError {

    public NameNotDefined(CodePos codePos, String name) {
        super(codePos, "\"" + name + "\" not defined", "NameNotDefined");
    }
}
