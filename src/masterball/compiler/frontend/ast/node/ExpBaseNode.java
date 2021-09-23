package masterball.compiler.frontend.ast.node;

import masterball.compiler.frontend.exception.CodePos;

public abstract class ExpBaseNode extends BaseNode {
    public ExpBaseNode(CodePos codePos) {
        super(codePos);
    }
}
