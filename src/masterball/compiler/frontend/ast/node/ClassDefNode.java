package masterball.compiler.frontend.ast.node;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.stmtnode.VarDefStmtNode;
import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.info.ClassRegistry;
import masterball.compiler.frontend.scope.ClassScope;

import java.util.ArrayList;

public class ClassDefNode extends BaseNode {
    public ClassRegistry classRegistry;

    public FuncDefNode constructorDefNode;
    public ArrayList<VarDefStmtNode> varDefStmtNodes;
    public ArrayList<FuncDefNode> funcDefNodes;

    public ClassDefNode(CodePos codePos) {
        super(codePos);
        this.constructorDefNode = null;
        this.varDefStmtNodes = new ArrayList<>();
        this.funcDefNodes = new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
