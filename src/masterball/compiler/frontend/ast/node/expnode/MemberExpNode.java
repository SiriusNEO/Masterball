package masterball.compiler.frontend.ast.node.expnode;

import masterball.compiler.share.pass.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.info.type.MxBaseType;

public class MemberExpNode extends ExpBaseNode {
    public ExpBaseNode superExpNode;

    public String memberName;

    public MemberExpNode(CodePos codePos, ExpBaseNode superExpNode, String memberName) {
        super(codePos);
        this.superExpNode = superExpNode;
        this.memberName = memberName;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isLeftValue() {
        return !this.type.match(MxBaseType.BuiltinType.FUNC);
    }
}
