package masterball.compiler.middleend.llvmir;

import masterball.compiler.middleend.llvmir.type.IRBaseType;

import java.util.ArrayList;

public class User extends Value {
    public final ArrayList<Value> operands = new ArrayList<Value>();

    public User(String name, IRBaseType type) {
        super(name, type);
    }

    public void addOperand(Value value) {
        if (value != null) value.addUser(this);
        operands.add(value);
    }

    public Value getOperand(int index) {
        return operands.get(index);
    }

    public void resetOperand(int index, Value value) {
        operands.get(index).users.remove(this);
        operands.set(index, value);
        value.addUser(this);
    }

    public int operandSize() {return operands.size();}
}
