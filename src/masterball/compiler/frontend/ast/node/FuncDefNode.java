package masterball.compiler.frontend.ast.node;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.exception.CodePos;
import masterball.compiler.frontend.scope.Registry;
import masterball.compiler.frontend.type.FuncType;

import java.util.ArrayList;

public class FuncDefNode extends BaseNode {
    public Registry funcRegistry;
    public ArrayList<VarDefNode> argsDefNodes;
    public SuiteNode suiteNode;

    public FuncDefNode(CodePos codePos) {
        super(codePos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
