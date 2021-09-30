package masterball.compiler.frontend.info.type;

import masterball.compiler.frontend.ast.node.ExpBaseNode;
import masterball.compiler.frontend.error.semantic.FuncCallError;
import masterball.compiler.frontend.info.registry.VarRegistry;

import java.util.ArrayList;

import static masterball.compiler.frontend.info.type.BaseType.BuiltinType.FUNC;

public class FuncType extends BaseType {
    public VarType retType;
    public ArrayList<VarType> funcArgsType;

    public FuncType() {
        super(BuiltinType.FUNC);
        retType = null;
        funcArgsType = new ArrayList<>();
    }

    @Override
    public boolean match(BaseType other) {return false;}

    @Override
    public boolean match(BuiltinType other) {return other == FUNC;}

    public int funcCallMatch(ArrayList<ExpBaseNode> args) {
        if (funcArgsType.size() != args.size()) {
            return -1;
        }
        for (int i = 0; i < funcArgsType.size(); i++) {
            if (!funcArgsType.get(i).match(args.get(i).type)) {
                return -2;
            }
        }
        return 0;
    }

    @Override
    public BaseType copy() {
        FuncType ret = new FuncType();
        ret.retType = (VarType) retType.copy();
        for (int i = 0; i < funcArgsType.size(); i++) {
            ret.funcArgsType.add((VarType) funcArgsType.get(i).copy());
        }
        return ret;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append(retType).append(" args:");
        for (int i = 0; i < funcArgsType.size(); ++i) {
            ret.append(funcArgsType.get(i).toString() + " ");
        }
        return ret.toString();
    }
}
