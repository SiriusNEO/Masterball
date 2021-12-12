package masterball.compiler.frontend.ast.node.stmtnode;

import masterball.compiler.share.pass.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.ast.node.StmtBaseNode;
import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.info.scope.LoopScope;

public class WhileStmtNode extends StmtBaseNode {

    public LoopScope scope;

    public ExpBaseNode conditionExpNode;
    public StmtBaseNode bodyStmtNode;

    public WhileStmtNode(CodePos codePos, ExpBaseNode conditionExpNode, StmtBaseNode bodyStmtNode) {
        super(codePos);
        this.scope = new LoopScope();
        this.conditionExpNode = conditionExpNode;
        this.bodyStmtNode = bodyStmtNode;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
