package masterball.compiler.frontend.scope;

public abstract class BaseScope {
    public BaseScope parentScope;

    abstract void query(String name);

    abstract void register(Registry registry);
}
