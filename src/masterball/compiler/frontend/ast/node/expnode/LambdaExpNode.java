package masterball.compiler.frontend.ast.node.expnode;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.ast.node.SuiteNode;
import masterball.compiler.frontend.ast.node.VarDefNode;
import masterball.compiler.frontend.exception.CodePos;

import java.util.ArrayList;

public class LambdaExpNode extends ExpBaseNode {
    public ArrayList<VarDefNode> argsDefNodes;
    public SuiteNode suiteNode;

    public LambdaExpNode(CodePos codePos) {
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
