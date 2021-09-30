package masterball.compiler.frontend.ast.node.expnode;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.parser.MxStarParser;

public class AtomExpNode extends ExpBaseNode {
    public MxStarParser.AtomContext ctx;

    public AtomExpNode(CodePos codePos, MxStarParser.AtomContext ctx) {
        super(codePos);
        this.ctx = ctx;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isLeftValue() {
        return true;
    }
}
