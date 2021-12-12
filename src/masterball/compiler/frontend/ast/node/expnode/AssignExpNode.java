package masterball.compiler.frontend.ast.node.expnode;

import masterball.compiler.share.pass.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.info.CodePos;

public class AssignExpNode extends ExpBaseNode {
    public ExpBaseNode lhsExpNode, rhsExpNode;

    public AssignExpNode(CodePos codePos, ExpBaseNode lhsExpNode, ExpBaseNode rhsExpNode) {
        super(codePos);
        this.lhsExpNode = lhsExpNode;
        this.rhsExpNode = rhsExpNode;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isLeftValue() {
        return true;
    }
}
