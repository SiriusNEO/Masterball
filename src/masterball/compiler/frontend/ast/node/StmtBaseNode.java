package masterball.compiler.frontend.ast.node;

import masterball.compiler.frontend.exception.CodePos;

public abstract class StmtBaseNode extends BaseNode {
    public StmtBaseNode(CodePos codePos) {
        super(codePos);
    }
}
