package masterball.compiler.frontend.ast.node;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.info.registry.FuncRegistry;
import masterball.compiler.frontend.info.type.BaseType;
import masterball.compiler.utils.MxStarTable;

import java.util.Objects;

public class FuncDefNode extends BaseNode {
    public FuncRegistry funcRegistry;

    public SuiteNode suiteNode;

    public FuncDefNode(CodePos codePos, FuncRegistry funcRegistry, SuiteNode suiteNode) {
        super(codePos);
        this.funcRegistry = funcRegistry;
        this.suiteNode = suiteNode;
    }

    public boolean isValidMainFunc() {
        return Objects.equals(funcRegistry.name, MxStarTable.mainKw)
               && funcRegistry.type.retType.match(BaseType.BuiltinType.INT)
               && funcRegistry.funcArgs.size() == 0;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
