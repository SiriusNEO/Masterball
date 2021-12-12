package masterball.compiler.frontend.ast.node;

import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.info.scope.GlobalScope;
import masterball.compiler.share.pass.ASTVisitor;

import java.util.ArrayList;

public class RootNode extends BaseNode {
    public ArrayList<BaseNode> sonNodes;

    public GlobalScope scope;

    public RootNode(CodePos pos) {
        super(pos);
        this.scope = new GlobalScope();
        this.sonNodes = new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
