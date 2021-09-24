package masterball.compiler.frontend.ast.node;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.exception.CodePos;
import masterball.compiler.frontend.scope.Registry;

public class VarDefNode extends BaseNode {
    public Registry varRegistry;

    public VarDefNode(CodePos codePos) {
        super(codePos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
