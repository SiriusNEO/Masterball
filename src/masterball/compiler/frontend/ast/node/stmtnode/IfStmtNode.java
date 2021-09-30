package masterball.compiler.frontend.ast.node.stmtnode;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.ast.node.StmtBaseNode;
import masterball.compiler.frontend.info.CodePos;

public class IfStmtNode extends StmtBaseNode {
    public ExpBaseNode conditionExpNode;
    public StmtBaseNode ifTrueStmtNode, elseStmtNode;

    public IfStmtNode(CodePos codePos, ExpBaseNode conditionExpNode, StmtBaseNode ifTrueStmtNode) {
        super(codePos);
        this.conditionExpNode = conditionExpNode;
        this.ifTrueStmtNode = ifTrueStmtNode;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
