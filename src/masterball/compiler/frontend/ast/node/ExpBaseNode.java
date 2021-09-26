package masterball.compiler.frontend.ast.node;

import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.info.Type;

public abstract class ExpBaseNode extends BaseNode {
    public Type type;

    public ExpBaseNode(CodePos codePos) {
        super(codePos);
    }

    public abstract boolean isLeftValue();
}
