package masterball.compiler.frontend.ast.node;

import masterball.compiler.share.pass.ASTVisitor;
import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.middleend.llvmir.Value;

public abstract class BaseNode {
    public CodePos codePos;
    // interact with IR part
    public Value value = null;

    public BaseNode(CodePos codePos) {
        this.codePos = codePos;
    }

    public abstract void accept(ASTVisitor visitor);
}
