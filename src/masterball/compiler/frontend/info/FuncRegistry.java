package masterball.compiler.frontend.info;

import masterball.compiler.frontend.info.Type;
import masterball.compiler.frontend.parser.MxStarParser;
import masterball.debugger.Log;
import masterball.debugger.VarPair;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class FuncRegistry extends Registry {

    public Type retType;
    public ArrayList<VarRegistry> funcArgs;

    public FuncRegistry(MxStarParser.FuncDefContext ctx) {
        super(ctx.Identifier().toString(), ctx);

        retType = new Type(ctx.varDefType());
        funcArgs = new ArrayList<>();

        MxStarParser.FuncDefArgsContext funcDefArgsContext = ctx.funcDefArgs();

        if (funcDefArgsContext != null) {
            List<MxStarParser.VarDefTypeContext> varDefTypeContextList = funcDefArgsContext.varDefType();
            List<TerminalNode> identifierList = funcDefArgsContext.Identifier();

            for (int i = 0; i < varDefTypeContextList.size(); ++i) {
                funcArgs.add(new VarRegistry(identifierList.get(i).toString(),
                             varDefTypeContextList.get(i)));
            }
        }

        Log.report(new VarPair("fname", ctx.Identifier().toString()),
                   new VarPair("rettype", retType.basicType == Type.BasicType.VOID),
                   new VarPair("argsize", funcArgs.size())
        );
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("ret:").append(retType);
        for (int i = 0; i < funcArgs.size(); ++i) {
            ret.append(funcArgs.get(i).toString());
        }
        return ret.toString();
    }
}
