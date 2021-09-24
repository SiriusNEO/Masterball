package masterball.compiler.frontend.ast.node.stmtnode;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.StmtBaseNode;
import masterball.compiler.frontend.exception.CodePos;

public class ControlStmtNode extends StmtBaseNode {
    public enum Command {BREAK, CONTINUE};
    public Command command;

    public ControlStmtNode(CodePos codePos, Command command) {
        super(codePos);
        this.command = command;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
