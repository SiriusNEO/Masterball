package masterball.compiler.frontend.ast.node.expnode;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.info.CodePos;
import masterball.debugger.Log;

public class PostfixExpNode extends ExpBaseNode {
    public String op;
    public ExpBaseNode selfExpNode;

    public PostfixExpNode(CodePos codePos, String op, ExpBaseNode selfExpNode) {
        super(codePos);
        this.op = op;
        this.selfExpNode = selfExpNode;
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
