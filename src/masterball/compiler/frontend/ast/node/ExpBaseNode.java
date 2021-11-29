package masterball.compiler.frontend.ast.node;

import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.info.type.BaseType;
import masterball.compiler.middleend.llvmir.hierarchy.BaseValue;

public abstract class ExpBaseNode extends BaseNode {
    public BaseType type;
    // interact with IR part
    public BaseValue value;

    public ExpBaseNode(CodePos codePos) {
        super(codePos);
        this.type = null;
    }

    public abstract boolean isLeftValue();
}
