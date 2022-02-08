package masterball.compiler.share.warn;

public class UninitiatedWarning extends Warning {
    public UninitiatedWarning(String name) {
        super("usage of initiated variable \"" + name + "\". Default initial value will be set 0/false/null");
    }
}
