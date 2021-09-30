package masterball.compiler.frontend.info;

import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.error.BaseError;
import masterball.compiler.frontend.error.semantic.FuncCallError;
import masterball.compiler.frontend.info.Type;
import masterball.compiler.frontend.parser.MxStarParser;
import masterball.compiler.frontend.scope.FuncArgScope;
import masterball.compiler.frontend.scope.NormalScope;
import masterball.debugger.Log;
import masterball.debugger.VarPair;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class FuncRegistry extends Registry {

    public Type retType;
    public ArrayList<VarRegistry> funcArgs;

    public FuncArgScope scope;

    public FuncRegistry(MxStarParser.FuncDefContext ctx) {
        super(ctx.Identifier().toString(), ctx);

        this.scope = new FuncArgScope();

        retType = new Type(ctx.varDefType());
        funcArgs = new ArrayList<>();

        MxStarParser.FuncDefArgsContext funcDefArgsContext = ctx.funcDefArgs();

        if (funcDefArgsContext != null) {
            for (int i = 0; i < funcDefArgsContext.varDefType().size(); ++i) {
                funcArgs.add(new VarRegistry(funcDefArgsContext.Identifier(i).toString(),
                        funcDefArgsContext.varDefType(i)));
            }
        }
    }

    public FuncRegistry(MxStarParser.ClassConstructorDefContext ctx) {
        super(ctx.Identifier().toString(), ctx);
        funcArgs = new ArrayList<>();
    }

    public boolean funcCallMatch(ArrayList<ExpBaseNode> args) {
        if (funcArgs.size() != args.size()) {
            throw new FuncCallError(codePos, FuncCallError.argcNotMatch, name);
        }
        for (int i = 0; i < funcArgs.size(); i++) {
            if (!funcArgs.get(i).type.match(args.get(i).type)) {
                throw new FuncCallError(funcArgs.get(i).codePos, FuncCallError.argTypeNotMatch, name);
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder("[FuncRegistry] ");
        ret.append("name:" + name + " ");
        ret.append("ret:").append(retType).append(" args:");
        for (int i = 0; i < funcArgs.size(); ++i) {
            ret.append(funcArgs.get(i).toString() + " ");
        }
        return ret.toString();
    }
}
