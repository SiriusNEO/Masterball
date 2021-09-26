package masterball.compiler.frontend.scope;

import masterball.compiler.frontend.info.Registry;

public abstract class BaseScope {

    abstract void query(String name);

    abstract void register(Registry registry);
}
