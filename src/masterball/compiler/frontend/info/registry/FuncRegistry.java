package masterball.compiler.frontend.info.registry;

import masterball.compiler.frontend.info.type.FuncType;
import masterball.compiler.frontend.info.type.VarType;
import masterball.compiler.frontend.parser.MxStarParser;
import masterball.compiler.frontend.scope.FuncScope;

import java.util.ArrayList;

public class FuncRegistry extends BaseRegistry {

    public FuncType type;
    public FuncScope scope;
    public ArrayList<VarRegistry> funcArgs;

    public FuncRegistry(MxStarParser.FuncDefContext ctx) {
        super(ctx.Identifier().toString(), ctx);

        this.scope = new FuncScope();
        this.type = new FuncType();

        type.retType = new VarType(ctx.varDefType());
        type.funcArgsType = new ArrayList<>();
        funcArgs = new ArrayList<>();

        MxStarParser.FuncDefArgsContext funcDefArgsContext = ctx.funcDefArgs();

        if (funcDefArgsContext != null) {
            for (int i = 0; i < funcDefArgsContext.varDefType().size(); ++i) {
                VarRegistry varRegistry = new VarRegistry(funcDefArgsContext.Identifier(i).toString(), funcDefArgsContext.varDefType(i));
                funcArgs.add(varRegistry);
                type.funcArgsType.add(varRegistry.type);
            }
        }
    }

    public FuncRegistry(MxStarParser.ClassConstructorDefContext ctx) {
        super(ctx.Identifier().toString(), ctx);
        funcArgs = new ArrayList<>();
    }

    public String toString() {
        StringBuilder ret = new StringBuilder("[FuncRegistry] ");
        ret.append("name: " + name + " ");
        ret.append("type: " + type);
        return ret.toString();
    }
}
