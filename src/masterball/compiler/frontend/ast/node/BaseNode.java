package masterball.compiler.frontend.ast.node;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.middleend.llvmir.hierarchy.BaseValue;

public abstract class BaseNode {
    public CodePos codePos;
    // interact with IR part
    public BaseValue value;

    public BaseNode(CodePos codePos) {
        this.codePos = codePos;
    }

    abstract public void accept(ASTVisitor visitor);
}
