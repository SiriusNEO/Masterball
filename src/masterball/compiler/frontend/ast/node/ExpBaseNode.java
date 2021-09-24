package masterball.compiler.frontend.ast.node;

import masterball.compiler.frontend.exception.CodePos;
import masterball.compiler.frontend.type.Type;

public abstract class ExpBaseNode extends BaseNode {
    public Type type;

    public ExpBaseNode(CodePos codePos) {
        super(codePos);
    }

    public abstract boolean isLeftValue();
}
