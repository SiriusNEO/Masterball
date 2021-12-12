package masterball.compiler.frontend.ast.node.stmtnode;

import masterball.compiler.share.pass.ASTVisitor;
import masterball.compiler.frontend.ast.node.StmtBaseNode;
import masterball.compiler.frontend.info.CodePos;

public class ControlStmtNode extends StmtBaseNode {
    public String controlWord;

    public ControlStmtNode(CodePos codePos, String controlWord) {
        super(codePos);
        this.controlWord = controlWord;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
