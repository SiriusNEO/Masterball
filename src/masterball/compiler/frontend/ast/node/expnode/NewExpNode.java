package masterball.compiler.frontend.ast.node.expnode;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.info.Type;

import java.util.ArrayList;

public class NewExpNode extends ExpBaseNode {
    public Type newType;

    public NewExpNode(CodePos codePos, Type newType) {
        super(codePos);
        this.newType = newType;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isLeftValue() {
        return false;
    }
}
