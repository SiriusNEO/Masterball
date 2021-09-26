package masterball.compiler.frontend.ast.node;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.stmtnode.VarDefStmtNode;
import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.info.FuncRegistry;
import masterball.compiler.frontend.info.Type;
import masterball.compiler.frontend.info.VarRegistry;
import masterball.compiler.frontend.scope.NormalScope;
import masterball.compiler.utils.KeywordTable;

import java.util.ArrayList;
import java.util.Objects;

public class FuncDefNode extends BaseNode {
    public FuncRegistry funcRegistry;
    public NormalScope scope;
    public SuiteNode suiteNode;

    public FuncDefNode(CodePos codePos) {
        super(codePos);
        this.scope = new NormalScope();
    }

    public boolean isValidMainFunc() {
        return Objects.equals(funcRegistry.name, KeywordTable.mainKw)
               && funcRegistry.retType.basicType == Type.BasicType.INT
               && funcRegistry.funcArgs.size() == 0;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
