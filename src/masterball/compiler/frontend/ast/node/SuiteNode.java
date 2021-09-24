package masterball.compiler.frontend.ast.node;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.exception.CodePos;
import masterball.compiler.frontend.scope.LocalityScope;

import java.util.ArrayList;

public class SuiteNode extends BaseNode {
    public ArrayList<StmtBaseNode> stmtNodes;

    public LocalityScope scope;

    public SuiteNode(CodePos codePos) {
        super(codePos);
        this.stmtNodes = new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
