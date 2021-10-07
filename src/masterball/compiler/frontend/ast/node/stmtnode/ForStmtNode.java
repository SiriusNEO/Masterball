package masterball.compiler.frontend.ast.node.stmtnode;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.ast.node.StmtBaseNode;
import masterball.compiler.frontend.ast.node.VarDefSingleNode;
import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.info.scope.LoopScope;
import masterball.compiler.frontend.info.scope.NormalScope;

import java.util.ArrayList;

public class ForStmtNode extends StmtBaseNode {
    // initExp and initVarDef are mutually exclusive

    public LoopScope scope;

    public ExpBaseNode initExpNode, conditionExpNode, incrExpNode;
    public ArrayList<VarDefSingleNode> initVarDefSingleNodes;
    public StmtBaseNode bodyStmtNode;

    public ForStmtNode(CodePos codePos) {
        super(codePos);
        this.scope = new LoopScope();
        initVarDefSingleNodes = new ArrayList<VarDefSingleNode>();
        this.initExpNode = this.conditionExpNode = this.incrExpNode = null;
        this.bodyStmtNode = null;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
