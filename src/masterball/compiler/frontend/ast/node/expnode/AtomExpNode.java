package masterball.compiler.frontend.ast.node.expnode;

import masterball.compiler.share.pass.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.parser.MxStarParser;

public class AtomExpNode extends ExpBaseNode {
    // literal content
    public MxStarParser.AtomContext ctx;

    public AtomExpNode(CodePos codePos, MxStarParser.AtomContext ctx) {
        super(codePos);
        this.ctx = ctx;
    }

    public String getStringLiteral() {
        String rawString =  this.ctx.StringConstant().toString();
        return rawString.substring(1, rawString.length()-1) // quote filter
                .replace("\\\"","\"")
                .replace("\\n","\n")
                .replace("\\t","\t")
                .replace("\\\\","\\");
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isLeftValue() {
        return ctx.Identifier() != null;
    }
}
