package masterball.compiler.frontend.ast.node.stmtnode;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.ast.node.StmtBaseNode;
import masterball.compiler.frontend.exception.CodePos;

public class WhileStmtNode extends StmtBaseNode {
    ExpBaseNode conditionExpNode;
    StmtBaseNode bodyStmtNode;

    public WhileStmtNode(CodePos codePos, ExpBaseNode conditionExpNode) {
        super(codePos);
        this.conditionExpNode = conditionExpNode;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
