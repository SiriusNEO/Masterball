package masterball.compiler.frontend.ast.node.expnode;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.info.CodePos;

import java.util.ArrayList;

public class FuncCallExpNode extends ExpBaseNode {
    public String callFuncName;
    public ArrayList<ExpBaseNode> callArgExpNodes;

    public FuncCallExpNode(CodePos codePos, String callFuncName) {
        super(codePos);
        this.callFuncName = callFuncName;
        this.callArgExpNodes = new ArrayList<ExpBaseNode>();
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
