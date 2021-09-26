package masterball.compiler.frontend.ast.node.stmtnode;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.StmtBaseNode;
import masterball.compiler.frontend.ast.node.SuiteNode;
import masterball.compiler.frontend.info.CodePos;

public class SuiteStmtNode extends StmtBaseNode {
    public SuiteNode suiteNode;

    public SuiteStmtNode(CodePos codePos, SuiteNode suiteNode) {
        super(codePos);
        this.suiteNode = suiteNode;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
