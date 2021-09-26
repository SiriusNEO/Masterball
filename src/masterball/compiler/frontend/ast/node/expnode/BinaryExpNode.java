package masterball.compiler.frontend.ast.node.expnode;

import masterball.compiler.frontend.ast.ASTVisitor;
import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.info.CodePos;

public class BinaryExpNode extends ExpBaseNode {
    ExpBaseNode lhsExpNode, rhsExpNode;
    public enum BinaryOp {
        AddOp, SubOp, MulOp, DivOp, ModOp,
        ArithShiftLeftOp, ArithShiftRightOp,
        GreaterOp, GreaterEqualOp, LessOp, LessEqualOp,
        EqualOp, NotEqualOp,
        BitAndOp, BitOrOp, BitXorOp,
        LogicAndOp, LogicOrOp
    };

    BinaryOp op;

    public BinaryExpNode(CodePos codePos) {
        super(codePos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isLeftValue() {
        return false;
    }
}
