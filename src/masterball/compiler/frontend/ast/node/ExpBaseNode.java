package masterball.compiler.frontend.ast.node;

import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.info.type.MxBaseType;
import masterball.compiler.middleend.llvmir.hierarchy.Value;

public abstract class ExpBaseNode extends BaseNode {
    public MxBaseType type;
    // interact with IR part
    public Value value;

    public ExpBaseNode(CodePos codePos) {
        super(codePos);
        this.type = null;
    }

    public abstract boolean isLeftValue();
}
