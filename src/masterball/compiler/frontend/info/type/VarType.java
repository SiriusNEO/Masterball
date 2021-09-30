package masterball.compiler.frontend.info.type;

import masterball.compiler.frontend.error.syntax.ArrayDeclarationError;
import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.parser.MxStarParser;
import masterball.debugger.Log;

import java.util.Objects;

public class VarType extends BaseType {
    public String className;

    public int dimension;  // for Array Object

    public VarType(BuiltinType builtinType) {
        super(builtinType);
        dimension = 0;
        className = "not a class";
    }

    public VarType(MxStarParser.VarDefTypeContext ctx) {
        super(BuiltinType.NULL);
        dimension = ctx.LeftBracket().size();
        className = "not a class";

        if (ctx.builtinType() != null) {
            if (ctx.builtinType().IntType() != null) builtinType = BuiltinType.INT;
            else if (ctx.builtinType().BoolType() != null) builtinType = BuiltinType.BOOL;
            else if (ctx.builtinType().StringType() != null) builtinType = BuiltinType.STRING;
            else if (ctx.builtinType().VoidType() != null) builtinType = BuiltinType.VOID;
        } else if (ctx.Identifier() != null) {
            builtinType = BuiltinType.CLASS;
            className = ctx.Identifier().toString();
        }
    }

    public VarType(MxStarParser.NewExpTypeContext ctx) {
        super(BuiltinType.NULL);
        dimension = ctx.newExpSizeDeclaration().size();
        className = "not a class";

        for (int i = 0; i < dimension-1; i++) {
            if (ctx.newExpSizeDeclaration(i).expression() == null &&
                ctx.newExpSizeDeclaration(i+1).expression() != null) {
                    throw new ArrayDeclarationError(
                            new CodePos(ctx.newExpSizeDeclaration(i)),
                            ArrayDeclarationError.outsizeFirst
                    );
            }
        }

        if (ctx.builtinType() != null) {
            if (ctx.builtinType().IntType() != null) builtinType = BuiltinType.INT;
            else if (ctx.builtinType().BoolType() != null) builtinType = BuiltinType.BOOL;
            else if (ctx.builtinType().StringType() != null) builtinType = BuiltinType.STRING;
            else if (ctx.builtinType().VoidType() != null) builtinType = BuiltinType.VOID;
        } else if (ctx.Identifier() != null) {
            builtinType = BuiltinType.CLASS;
            className = ctx.Identifier().toString();
        }
    }

    public BaseType copy() {
        VarType ret = new VarType(builtinType);
        ret.dimension = dimension;
        ret.className = className;
        return ret;
    }

    @Override
    public boolean match(BaseType other) {
        if (other instanceof VarType) {
            return builtinType == other.builtinType &&
                    Objects.equals(className, ((VarType) other).className)
                    && dimension == ((VarType) other).dimension;
        }
        return builtinType == other.builtinType;
    }

    @Override
    public boolean match(BuiltinType other) {
        return builtinType == other;
    }

    public String toString() {
        StringBuilder ret = null;

        if (builtinType == BuiltinType.CLASS) ret = new StringBuilder(className);
        else ret = new StringBuilder(builtinType.toString());

        for (int i = 0; i < dimension; ++i) ret.append("[]");
        return ret.toString();
    }
}