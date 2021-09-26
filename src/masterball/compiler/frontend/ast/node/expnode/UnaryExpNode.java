package masterball.compiler.frontend.ast.node.expnode;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.info.CodePos;

public class UnaryExpNode extends ExpBaseNode {
    public UnaryExpNode(CodePos codePos) {
        super(codePos);
    }

    public enum UnaryOp {BitNotOp, LogicNotOp, PositiveOp, NegativeOp};
    public UnaryOp op;
    ExpBaseNode selfExpNode;

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isLeftValue() {
        return false;
    }
}
