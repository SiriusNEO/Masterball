package masterball.compiler.frontend.ast.node.stmtnode;

import masterball.compiler.share.pass.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.ast.node.StmtBaseNode;
import masterball.compiler.frontend.info.CodePos;

public class ReturnStmtNode extends StmtBaseNode {
    public ExpBaseNode retExpNode;

    public ReturnStmtNode(CodePos codePos) {
        super(codePos);
        this.retExpNode = null;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
