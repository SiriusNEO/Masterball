package masterball.compiler.frontend.info;

import masterball.compiler.frontend.parser.MxStarParser;
import masterball.debugger.Log;
import masterball.debugger.VarPair;

import java.util.Objects;

import static masterball.compiler.frontend.info.Type.BasicType.*;
import static masterball.compiler.utils.KeywordTable.*;

public class Type {
    public enum BasicType {NULL, INT, BOOL, STRING, VOID, CLASS};

    public BasicType basicType;
    public String className;

    public int dimension;  // for Array Object

    public Type(MxStarParser.VarDefTypeContext ctx) {
        dimension = ctx.arrayType().size();;
        className = "not a class";
        basicType = NULL;

        MxStarParser.BuiltinTypeContext builtinTypeContext = ctx.builtinType();

        if (builtinTypeContext != null) {
            if (builtinTypeContext.IntType() != null) basicType = INT;
            else if (builtinTypeContext.BoolType() != null) basicType = BOOL;
            else if (builtinTypeContext.StringType() != null) basicType = STRING;
            else if (builtinTypeContext.VoidType() != null) basicType = VOID;
        } else if (ctx.Identifier() != null) {
            basicType = Type.BasicType.CLASS;
            className = ctx.Identifier().toString();
        }
    }

    public String toString() {
        String ret = null;

        if (basicType == NULL) ret = nullKw;
        else if (basicType == INT) ret = intKw;
        else if (basicType == BOOL) ret = boolKw;
        else if (basicType == STRING) ret = stringKw;
        else if (basicType == VOID) ret = voidKw;
        return ret + ", dim:" + dimension;
    }
}