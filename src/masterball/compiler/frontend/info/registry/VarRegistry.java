package masterball.compiler.frontend.info.registry;

import masterball.compiler.frontend.info.type.MxBaseType;
import masterball.compiler.frontend.info.type.VarType;
import masterball.compiler.frontend.parser.MxStarParser;

import java.util.ArrayList;

public class VarRegistry extends BaseRegistry {
    public VarType type;
    public ArrayList<VarRegistry> eachDimLength;

    public VarRegistry(String name, MxBaseType.BuiltinType builtinType) {
        super(name);
        type = new VarType(builtinType);
        eachDimLength = new ArrayList<>();
    }

    public VarRegistry(String name, MxStarParser.VarDefSingleContext ctx) {
        super(name, ctx);
        eachDimLength = new ArrayList<>();
    }

    public VarRegistry(String name, MxStarParser.VarDefTypeContext ctx) {
        super(name, ctx);
        this.type = new VarType(ctx);
        eachDimLength = new ArrayList<>();
    }

    public String toString() {
        StringBuilder ret = new StringBuilder("[VarRegistry] ");
        ret.append(type + "|" + name);
        return ret.toString();
    }
}
