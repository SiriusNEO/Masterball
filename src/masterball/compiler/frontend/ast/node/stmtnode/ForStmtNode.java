package masterball.compiler.frontend.ast.node.stmtnode;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.ast.node.StmtBaseNode;
import masterball.compiler.frontend.exception.CodePos;

public class ForStmtNode extends StmtBaseNode {
    ExpBaseNode initExpNode, conditionExpNode, incrExpNode;

    public ForStmtNode(CodePos codePos, ExpBaseNode initExpNode, ExpBaseNode conditionExpNode, ExpBaseNode incrExpNode) {
        super(codePos);
        this.initExpNode = initExpNode;
        this.conditionExpNode = conditionExpNode;
        this.incrExpNode = incrExpNode;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
