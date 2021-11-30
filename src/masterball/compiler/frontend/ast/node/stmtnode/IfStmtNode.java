package masterball.compiler.frontend.ast.node.stmtnode;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.ast.node.StmtBaseNode;
import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.info.scope.IfScope;

public class IfStmtNode extends StmtBaseNode {

    public IfScope ifTrueScope, elseScope;

    public ExpBaseNode conditionExpNode;
    public StmtBaseNode ifTrueStmtNode, elseStmtNode;

    public IfStmtNode(CodePos codePos, ExpBaseNode conditionExpNode, StmtBaseNode ifTrueStmtNode) {
        super(codePos);
        this.ifTrueScope = new IfScope();
        this.elseScope = new IfScope();
        this.conditionExpNode = conditionExpNode;
        this.ifTrueStmtNode = ifTrueStmtNode;
        this.elseStmtNode = null;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
