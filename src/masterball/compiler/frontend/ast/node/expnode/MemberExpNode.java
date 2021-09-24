package masterball.compiler.frontend.ast.node.expnode;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.exception.CodePos;

public class MemberExpNode extends ExpBaseNode {
    public ExpBaseNode superExpNode;
    public ExpBaseNode memberExpNode;
    public boolean isMemberVar; // true: var, false: func

    public MemberExpNode(CodePos codePos) {
        super(codePos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isLeftValue() {
        return isMemberVar;
    }
}
