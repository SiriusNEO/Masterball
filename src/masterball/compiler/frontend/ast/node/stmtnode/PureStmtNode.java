package masterball.compiler.frontend.ast.node.stmtnode;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.ast.node.StmtBaseNode;
import masterball.compiler.frontend.info.CodePos;

public class PureStmtNode extends StmtBaseNode {
    public ExpBaseNode expNode;

    public PureStmtNode(CodePos codePos, ExpBaseNode expNode) {
        super(codePos);
        this.expNode = expNode;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
