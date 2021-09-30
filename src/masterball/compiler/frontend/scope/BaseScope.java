package masterball.compiler.frontend.scope;

import masterball.compiler.frontend.info.registry.ClassRegistry;
import masterball.compiler.frontend.info.registry.FuncRegistry;
import masterball.compiler.frontend.info.registry.BaseRegistry;
import masterball.compiler.frontend.info.registry.VarRegistry;

public abstract class BaseScope {

    public abstract ClassRegistry queryClass(String name);

    public abstract FuncRegistry queryFunc(String name);

    public abstract VarRegistry queryVar(String name);

    public abstract void register(BaseRegistry registry);
}
