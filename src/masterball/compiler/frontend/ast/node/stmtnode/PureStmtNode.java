package masterball.compiler.frontend.ast.node.stmtnode;

import masterball.compiler.share.pass.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.ast.node.StmtBaseNode;
import masterball.compiler.frontend.info.CodePos;

public class PureStmtNode extends StmtBaseNode {
    public ExpBaseNode expNode;

    public PureStmtNode(CodePos codePos) {
        super(codePos);
        this.expNode = null;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
