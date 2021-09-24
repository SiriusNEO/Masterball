package masterball.compiler.frontend.ast.node.stmtnode;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.StmtBaseNode;
import masterball.compiler.frontend.ast.node.VarDefNode;
import masterball.compiler.frontend.exception.CodePos;
import masterball.compiler.frontend.scope.Registry;

public class VarDefStmtNode extends StmtBaseNode {
    VarDefNode varDefNode;

    public VarDefStmtNode(CodePos codePos) {
        super(codePos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
