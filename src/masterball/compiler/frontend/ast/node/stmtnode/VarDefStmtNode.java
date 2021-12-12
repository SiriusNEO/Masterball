package masterball.compiler.frontend.ast.node.stmtnode;

import masterball.compiler.share.pass.ASTVisitor;
import masterball.compiler.frontend.ast.node.StmtBaseNode;
import masterball.compiler.frontend.ast.node.VarDefSingleNode;
import masterball.compiler.frontend.info.CodePos;

import java.util.ArrayList;

public class VarDefStmtNode extends StmtBaseNode {

    public ArrayList<VarDefSingleNode> varDefSingleNodes;

    public VarDefStmtNode(CodePos codePos) {
        super(codePos);
        varDefSingleNodes = new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
