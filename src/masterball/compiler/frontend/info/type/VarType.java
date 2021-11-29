package masterball.compiler.frontend.info.type;

import masterball.compiler.utils.error.semantic.TypeError;
import masterball.compiler.utils.error.syntax.ArrayDeclarationError;
import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.parser.MxStarParser;

import java.util.Objects;

public class VarType extends BaseType {

    public static final String notClass = "not a class";

    public String className;

    public int dimension;  // for Array Object

    public VarType(BuiltinType builtinType) {
        super(builtinType);
        dimension = 0;
        className = notClass;
    }

    public VarType(String className) {
        super(BuiltinType.CLASS);
        this.className = className;
        dimension = 0;
    }

    public VarType(MxStarParser.VarDefTypeContext ctx, boolean isFuncRetType) {
        super(BuiltinType.NULL);
        dimension = ctx.LeftBracket().size();
        className = notClass;

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

    public VarType(MxStarParser.VarDefTypeContext ctx) {
        super(BuiltinType.NULL);
        dimension = ctx.LeftBracket().size();
        className = notClass;

        if (ctx.builtinType() != null) {
            if (ctx.builtinType().IntType() != null) builtinType = BuiltinType.INT;
            else if (ctx.builtinType().BoolType() != null) builtinType = BuiltinType.BOOL;
            else if (ctx.builtinType().StringType() != null) builtinType = BuiltinType.STRING;
            else if (ctx.builtinType().VoidType() != null) {
                throw new TypeError(new CodePos(ctx), TypeError.canNotBeVoid);
            }
        } else if (ctx.Identifier() != null) {
            builtinType = BuiltinType.CLASS;
            className = ctx.Identifier().toString();
        }
    }

    public VarType(MxStarParser.NewExpContext ctx) {
        super(BuiltinType.NULL);
        dimension = ctx.newExpSizeDeclaration().size();
        className = notClass;

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
            else if (ctx.builtinType().VoidType() != null)  {
                throw new TypeError(new CodePos(ctx), TypeError.canNotBeVoid);
            }
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
            if ((dimension > 0 || builtinType == BuiltinType.CLASS) && other.builtinType == BuiltinType.NULL) {
                return true;
            }
            return builtinType == other.builtinType &&
                    Objects.equals(className, ((VarType) other).className)
                    && dimension == ((VarType) other).dimension;
        }
        return false;
    }

    @Override
    public boolean match(BuiltinType other) {
        if ((dimension > 0 || builtinType == BuiltinType.CLASS) && other == BuiltinType.NULL) {
            return true;
        }
        return builtinType == other && dimension == 0;
    }

    public String toString() {
        StringBuilder ret = null;

        if (builtinType == BuiltinType.CLASS) ret = new StringBuilder(className);
        else ret = new StringBuilder(builtinType.toString());

        for (int i = 0; i < dimension; ++i) ret.append("[]");
        return ret.toString();
    }
}