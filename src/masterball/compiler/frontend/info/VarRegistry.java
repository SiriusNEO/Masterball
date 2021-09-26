package masterball.compiler.frontend.info;

import masterball.compiler.frontend.parser.MxStarParser;

import java.util.Objects;

import static masterball.compiler.utils.KeywordTable.*;

public class VarRegistry extends Registry {
    public Type type;

    // this registry is only for single var, so the parameter is not VarDefBodyContext.
    public VarRegistry(String name, MxStarParser.VarDefTypeContext ctx) {
        super(name, ctx);
        type = new Type(ctx);
    }

    public String toString() {
        return type + "|" + name;
    }
}
