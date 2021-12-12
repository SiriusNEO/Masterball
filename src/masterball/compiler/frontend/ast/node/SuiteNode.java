package masterball.compiler.frontend.ast.node;

import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.info.scope.NormalScope;
import masterball.compiler.share.pass.ASTVisitor;

import java.util.ArrayList;

public class SuiteNode extends BaseNode {
    public ArrayList<StmtBaseNode> stmtNodes;

    public NormalScope scope;

    public SuiteNode(CodePos codePos) {
        super(codePos);
        this.scope = new NormalScope();
        this.stmtNodes = new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
