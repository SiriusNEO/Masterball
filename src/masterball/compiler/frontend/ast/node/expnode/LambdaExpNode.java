package masterball.compiler.frontend.ast.node.expnode;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.ast.node.SuiteNode;
import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.info.registry.FuncRegistry;

import java.util.ArrayList;

public class LambdaExpNode extends ExpBaseNode {
    public FuncRegistry funcRegistry;
    public SuiteNode suiteNode;
    public ArrayList<ExpBaseNode> callArgExpNodes;

    public LambdaExpNode(CodePos codePos, SuiteNode suiteNode) {
        super(codePos);
        this.suiteNode = suiteNode;
        callArgExpNodes = new ArrayList<>();
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
