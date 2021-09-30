package masterball.compiler.frontend.ast.node;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.info.FuncRegistry;
import masterball.compiler.frontend.info.Type;
import masterball.compiler.frontend.scope.NormalScope;
import masterball.compiler.utils.GrammarTable;

import java.util.ArrayList;
import java.util.Objects;

public class FuncDefNode extends BaseNode {
    public FuncRegistry funcRegistry;

    public SuiteNode suiteNode;

    public FuncDefNode(CodePos codePos) {
        super(codePos);
        this.funcRegistry = null;
        this.suiteNode = null;
    }

    public boolean isValidMainFunc() {
        return Objects.equals(funcRegistry.name, GrammarTable.mainKw)
               && funcRegistry.retType.basicType == Type.BasicType.INT
               && funcRegistry.funcArgs.size() == 0;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
