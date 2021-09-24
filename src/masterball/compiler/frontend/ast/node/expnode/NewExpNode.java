package masterball.compiler.frontend.ast.node.expnode;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.BaseNode;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.exception.CodePos;
import masterball.compiler.frontend.type.Type;

import java.util.ArrayList;

public class NewExpNode extends ExpBaseNode {
    public Type newType;
    public ArrayList<Integer> dimensionSize;

    public NewExpNode(CodePos codePos) {
        super(codePos);
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
