package masterball.compiler.frontend.ast.node.stmtnode;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.ast.node.StmtBaseNode;
import masterball.compiler.frontend.ast.node.VarDefSingleNode;
import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.scope.NormalScope;

import java.util.ArrayList;

public class ForStmtNode extends StmtBaseNode {
    // initExp and initVarDef are mutually exclusive

    public ExpBaseNode initExpNode, conditionExpNode, incrExpNode;
    public ArrayList<VarDefSingleNode> initVarDefSingleNodes;
    public StmtBaseNode bodyStmtNode;
    public NormalScope scope;

    public ForStmtNode(CodePos codePos) {
        super(codePos);
        this.scope = new NormalScope();
        initVarDefSingleNodes = new ArrayList<VarDefSingleNode>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
