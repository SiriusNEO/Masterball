package masterball.debugger;

public class VarPair {
    String name;
    Object val;

    public VarPair(String name, Object val) {
        this.name = name;
        this.val = val;
    }

    public String toString() {
        return name + ": " + val.toString();
    }
}
