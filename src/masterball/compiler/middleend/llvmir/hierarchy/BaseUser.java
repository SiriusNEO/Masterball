package masterball.compiler.middleend.llvmir.hierarchy;

import masterball.compiler.middleend.llvmir.type.BaseType;

import java.util.ArrayList;

public class BaseUser extends BaseValue {
    public ArrayList<BaseValue> operands = new ArrayList<BaseValue>();

    public BaseUser(String name, BaseType type) {
        super(name, type);
    }

    public void addOperand(BaseValue value) {
        if (value != null) value.addUser(this);
        operands.add(value);
    }

    public BaseValue getOperand(int index) {
        return operands.get(index);
    }
}
