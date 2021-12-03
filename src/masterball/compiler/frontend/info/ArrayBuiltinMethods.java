package masterball.compiler.frontend.info;

import masterball.compiler.frontend.info.registry.FuncRegistry;
import masterball.compiler.frontend.info.scope.ClassScope;
import masterball.compiler.frontend.info.type.MxBaseType;

public class ArrayBuiltinMethods {

    public static ClassScope scope = new ClassScope();

    static {
        scope.register(
                new FuncRegistry("size", MxBaseType.BuiltinType.INT)
        );
    }

}
