package masterball.compiler.frontend.ast.node.expnode;

import masterball.compiler.share.pass.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.info.CodePos;

public class PrefixExpNode extends ExpBaseNode {
    public String op;
    public ExpBaseNode selfExpNode;

    public PrefixExpNode(CodePos codePos, String op, ExpBaseNode selfExpNode) {
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
        return true;
    }
}
