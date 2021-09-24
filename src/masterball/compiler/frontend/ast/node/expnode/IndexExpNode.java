package masterball.compiler.frontend.ast.node.expnode;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.BaseNode;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.exception.CodePos;

public class IndexExpNode extends ExpBaseNode {
    ExpBaseNode arrayExpNode;
    ExpBaseNode indexExpNode;

    public IndexExpNode(CodePos codePos) {
        super(codePos);
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
