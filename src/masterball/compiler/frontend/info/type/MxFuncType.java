package masterball.compiler.frontend.info.type;

import masterball.compiler.frontend.ast.node.ExpBaseNode;

import java.util.ArrayList;

import static masterball.compiler.frontend.info.type.MxBaseType.BuiltinType.FUNC;

public class MxFuncType extends MxBaseType {
    public VarType retType;
    public ArrayList<VarType> funcArgsType;

    public MxFuncType() {
        super(BuiltinType.FUNC);
        retType = null;
        funcArgsType = new ArrayList<>();
    }

    @Override
    public boolean match(MxBaseType other) {return false;}

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
    public MxBaseType copy() {
        MxFuncType ret = new MxFuncType();
        ret.retType = (VarType) retType.copy();
        for (int i = 0; i < funcArgsType.size(); i++) {
            ret.funcArgsType.add((VarType) funcArgsType.get(i).copy());
        }
        return ret;
    }

    @Override
    public boolean isArray() {
        return false;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("func, retType:").append(retType).append(" args:");
        for (int i = 0; i < funcArgsType.size(); ++i) {
            ret.append(funcArgsType.get(i).toString() + " ");
        }
        return ret.toString();
    }
}
