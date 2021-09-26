package masterball.compiler.frontend.ast.node.stmtnode;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.ast.node.StmtBaseNode;
import masterball.compiler.frontend.info.CodePos;

public class ReturnStmtNode extends StmtBaseNode {
    ExpBaseNode retExpNode;

    public ReturnStmtNode(CodePos codePos, ExpBaseNode retExpNode) {
        super(codePos);
        this.retExpNode = retExpNode;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
