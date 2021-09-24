package masterball.compiler.frontend.ast.node.stmtnode;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.ast.node.StmtBaseNode;
import masterball.compiler.frontend.exception.CodePos;

public class ForStmtNode extends StmtBaseNode {
    ExpBaseNode initExpNode, conditionExpNode, incrExpNode;
    StmtBaseNode bodyStmtNode;

    public ForStmtNode(CodePos codePos) {
        super(codePos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
