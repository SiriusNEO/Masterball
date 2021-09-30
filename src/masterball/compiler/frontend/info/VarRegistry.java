package masterball.compiler.frontend.info;

import masterball.compiler.frontend.parser.MxStarParser;

import java.util.ArrayList;

public class VarRegistry extends Registry {
    public Type type;
    public ArrayList<VarRegistry> eachDimSize;

    public VarRegistry(String name, MxStarParser.VarDefSingleContext ctx) {
        super(name, ctx);
        eachDimSize = new ArrayList<>();
    }

    public VarRegistry(String name, MxStarParser.VarDefTypeContext ctx) {
        super(name, ctx);
        this.type = new Type(ctx);
        eachDimSize = new ArrayList<>();
    }

    public String toString() {
        StringBuilder ret = new StringBuilder("[VarRegistry] ");
        ret.append(type + "|" + name);
        return ret.toString();
    }
}
