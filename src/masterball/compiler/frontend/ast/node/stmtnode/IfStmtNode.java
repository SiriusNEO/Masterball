package masterball.compiler.frontend.ast.node.stmtnode;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.ast.node.StmtBaseNode;
import masterball.compiler.frontend.info.CodePos;

public class IfStmtNode extends StmtBaseNode {
    public ExpBaseNode conditionExpNode;
    StmtBaseNode bodyStmtNode;

    public IfStmtNode(CodePos codePos, ExpBaseNode conditionExpNode) {
        super(codePos);
        this.conditionExpNode = conditionExpNode;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
