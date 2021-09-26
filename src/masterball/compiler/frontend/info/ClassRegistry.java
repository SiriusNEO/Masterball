package masterball.compiler.frontend.info;

import masterball.compiler.frontend.parser.MxStarParser;

import java.util.HashMap;

public class ClassRegistry extends Registry {

    public HashMap<String, VarRegistry> memberVarTypes;
    public HashMap<String, FuncRegistry> memberFuncTypes;

    public ClassRegistry(MxStarParser.ClassDefContext ctx) {
        super(ctx.Identifier().toString(), ctx);
    }
}
