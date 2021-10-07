package masterball.compiler.frontend.info.registry;

import masterball.compiler.frontend.error.semantic.TypeError;
import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.frontend.info.type.BaseType;
import masterball.compiler.frontend.info.type.VarType;
import masterball.compiler.frontend.parser.MxStarParser;

import java.util.ArrayList;

public class VarRegistry extends BaseRegistry {
    public VarType type;
    public ArrayList<VarRegistry> eachDimSize;

    public VarRegistry(String name, BaseType.BuiltinType builtinType) {
        super(name);
        type = new VarType(builtinType);
        eachDimSize = new ArrayList<>();
    }

    public VarRegistry(String name, MxStarParser.VarDefSingleContext ctx) {
        super(name, ctx);
        eachDimSize = new ArrayList<>();
    }

    public VarRegistry(String name, MxStarParser.VarDefTypeContext ctx) {
        super(name, ctx);
        this.type = new VarType(ctx);
        eachDimSize = new ArrayList<>();
    }

    public String toString() {
        StringBuilder ret = new StringBuilder("[VarRegistry] ");
        ret.append(type + "|" + name);
        return ret.toString();
    }
}
