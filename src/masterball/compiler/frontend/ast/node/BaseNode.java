package masterball.compiler.frontend.ast.node;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.info.CodePos;

public abstract class BaseNode {
    public CodePos codePos;

    public BaseNode(CodePos codePos) {
        this.codePos = codePos;
    }

    abstract public void accept(ASTVisitor visitor);
}
