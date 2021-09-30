package masterball.compiler.frontend.scope;

import masterball.compiler.frontend.info.ClassRegistry;
import masterball.compiler.frontend.info.FuncRegistry;
import masterball.compiler.frontend.info.Registry;
import masterball.compiler.frontend.info.VarRegistry;

public abstract class BaseScope {

    public abstract ClassRegistry queryClass(String name);

    public abstract FuncRegistry queryFunc(String name);

    public abstract VarRegistry queryVar(String name);

    public abstract void register(Registry registry);
}
