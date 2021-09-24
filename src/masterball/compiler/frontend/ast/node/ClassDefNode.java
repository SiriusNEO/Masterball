package masterball.compiler.frontend.ast.node;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.stmtnode.VarDefStmtNode;
import masterball.compiler.frontend.exception.CodePos;
import masterball.compiler.frontend.scope.ClassScope;
import masterball.compiler.frontend.scope.Registry;

import java.util.ArrayList;

public class ClassDefNode extends BaseNode {
    public Registry classRegistry;

    public FuncDefNode constructorDefNode;
    public ArrayList<VarDefStmtNode> memberVarDefStmtNodes;
    public ArrayList<FuncDefNode> memberFuncDefNodes;

    public ClassScope scope;

    public ClassDefNode(CodePos codePos, FuncDefNode constructorDefNode) {
        super(codePos);
        this.constructorDefNode = constructorDefNode;
        memberVarDefStmtNodes = new ArrayList<>();
        memberFuncDefNodes = new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
