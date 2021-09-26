package masterball.compiler.frontend.ast.node;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.stmtnode.VarDefStmtNode;
import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.scope.GlobalScope;

import java.util.ArrayList;

public class RootNode extends BaseNode {
    public ArrayList<ClassDefNode> classDefNodes;
    public ArrayList<VarDefStmtNode> globalVarDefStmtNodes;
    public ArrayList<FuncDefNode> globalFuncDefNodes;

    public GlobalScope scope;

    public RootNode(CodePos pos) {
        super(pos);
        this.scope = new GlobalScope();
        this.classDefNodes = new ArrayList<>();
        this.globalVarDefStmtNodes = new ArrayList<>();
        this.globalFuncDefNodes = new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
