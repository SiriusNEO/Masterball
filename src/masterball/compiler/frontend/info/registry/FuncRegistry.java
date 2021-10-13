package masterball.compiler.frontend.info.registry;

import masterball.compiler.frontend.info.type.BaseType;
import masterball.compiler.frontend.info.type.FuncType;
import masterball.compiler.frontend.info.type.VarType;
import masterball.compiler.frontend.parser.MxStarParser;
import masterball.compiler.frontend.info.scope.FuncScope;

import java.util.ArrayList;

public class FuncRegistry extends BaseRegistry {

    public FuncType type;
    public FuncScope scope;
    public ArrayList<VarRegistry> funcArgs;

    //builtin function
    public FuncRegistry(String name, BaseType.BuiltinType retType, VarRegistry... args) {
        super(name);

        this.scope = new FuncScope();
        this.type = new FuncType();

        type.retType = new VarType(retType);

        type.funcArgsType = new ArrayList<>();
        funcArgs = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            funcArgs.add(args[i]);
            type.funcArgsType.add(args[i].type);
        }
    }

    //lambda
    public FuncRegistry(MxStarParser.LambdaExpContext ctx) {
        super("", ctx);

        this.scope = new FuncScope();
        this.type = new FuncType();

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

    //normal
    public FuncRegistry(MxStarParser.FuncDefContext ctx) {
        super(ctx.Identifier().toString(), ctx);

        this.scope = new FuncScope();
        this.type = new FuncType();

        type.retType = new VarType(ctx.varDefType(), true);
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

    //constructor
    public FuncRegistry(MxStarParser.ClassConstructorDefContext ctx) {
        super(ctx.Identifier().toString(), ctx);

        this.scope = new FuncScope();
        this.type = new FuncType();
        type.retType = new VarType(BaseType.BuiltinType.VOID);

        funcArgs = new ArrayList<>();
    }

    public String toString() {
        StringBuilder ret = new StringBuilder("[FuncRegistry] ");
        ret.append("name: " + name + " ");
        ret.append("type: " + type);
        return ret.toString();
    }
}
