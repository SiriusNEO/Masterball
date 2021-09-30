package masterball.compiler.frontend.info;

import masterball.compiler.frontend.error.syntax.ArrayDeclarationError;
import masterball.compiler.frontend.parser.MxStarParser;

import java.util.Objects;

import static masterball.compiler.frontend.info.Type.BasicType.*;
import static masterball.compiler.utils.GrammarTable.*;

public class Type {
    public enum BasicType {NULL, INT, BOOL, STRING, VOID, CLASS, THIS};

    public BasicType basicType;
    public String className;

    public int dimension;  // for Array Object

    public Type(BasicType basicType) {
        this.basicType = basicType;
        dimension = 0;
        className = "not a class";
    }

    public Type(MxStarParser.VarDefTypeContext ctx) {
        dimension = ctx.LeftBracket().size();
        className = "not a class";
        basicType = NULL;

        if (ctx.builtinType() != null) {
            if (ctx.builtinType().IntType() != null) basicType = INT;
            else if (ctx.builtinType().BoolType() != null) basicType = BOOL;
            else if (ctx.builtinType().StringType() != null) basicType = STRING;
            else if (ctx.builtinType().VoidType() != null) basicType = VOID;
        } else if (ctx.Identifier() != null) {
            basicType = Type.BasicType.CLASS;
            className = ctx.Identifier().toString();
        }
    }

    public Type(MxStarParser.NewExpTypeContext ctx) {
        dimension = ctx.newExpSizeDeclaration().size();
        className = "not a class";
        basicType = NULL;

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
            if (ctx.builtinType().IntType() != null) basicType = INT;
            else if (ctx.builtinType().BoolType() != null) basicType = BOOL;
            else if (ctx.builtinType().StringType() != null) basicType = STRING;
            else if (ctx.builtinType().VoidType() != null) basicType = VOID;
        } else if (ctx.Identifier() != null) {
            basicType = Type.BasicType.CLASS;
            className = ctx.Identifier().toString();
        }
    }

    public boolean match(Type other) {
        return basicType == other.basicType &&
                Objects.equals(className, other.className) &&
                dimension == other.dimension;
    }

    public boolean match(BasicType other) {
        return basicType == other;
    }

    public String toString() {
        StringBuilder ret = null;

        if (basicType == NULL) ret = new StringBuilder(nullKw);
        else if (basicType == INT) ret = new StringBuilder(intKw);
        else if (basicType == BOOL) ret = new StringBuilder(boolKw);
        else if (basicType == STRING) ret = new StringBuilder(stringKw);
        else if (basicType == VOID) ret = new StringBuilder(voidKw);
        else if (basicType == CLASS) ret = new StringBuilder(className);

        for (int i = 0; i < dimension; ++i) ret.append("[]");
        return ret.toString();
    }
}