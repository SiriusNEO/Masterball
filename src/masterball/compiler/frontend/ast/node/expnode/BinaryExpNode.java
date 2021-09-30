package masterball.compiler.frontend.ast.node.expnode;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.utils.GrammarTable;

public class BinaryExpNode extends ExpBaseNode {
    public ExpBaseNode lhsExpNode, rhsExpNode;
    public String op;

    public BinaryExpNode(CodePos codePos, ExpBaseNode lhsExpNode, ExpBaseNode rhsExpNode) {
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
        return false;
    }
}
