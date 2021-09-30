package masterball.compiler.frontend.ast.node.expnode;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.info.CodePos;

public class IndexExpNode extends ExpBaseNode {
    public ExpBaseNode arrayExpNode;
    public ExpBaseNode indexExpNode;

    public IndexExpNode(CodePos codePos, ExpBaseNode arrayExpNode, ExpBaseNode indexExpNode) {
        super(codePos);
        this.arrayExpNode = arrayExpNode;
        this.indexExpNode = indexExpNode;
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
