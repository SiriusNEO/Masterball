package masterball.compiler.frontend.ast.node.expnode;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.exception.CodePos;

public class PostfixExpNode extends ExpBaseNode {
    public enum PostfixOp {AddOp, SubOp};
    public PostfixOp op;
    ExpBaseNode selfExpNode;

    public PostfixExpNode(CodePos codePos) {
        super(codePos);
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
