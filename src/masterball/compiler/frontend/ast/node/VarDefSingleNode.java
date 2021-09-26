package masterball.compiler.frontend.ast.node;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.info.VarRegistry;

public class VarDefSingleNode extends BaseNode {
    public VarRegistry varRegistry;
    public ExpBaseNode initExpNode;

    public VarDefSingleNode(CodePos codePos) {
        super(codePos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
