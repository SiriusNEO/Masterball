package masterball.compiler.frontend.ast.node;

import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.info.type.BaseType;

public abstract class ExpBaseNode extends BaseNode {
    public BaseType type;

    public ExpBaseNode(CodePos codePos) {
        super(codePos);
        this.type = null;
    }

    public abstract boolean isLeftValue();
}
