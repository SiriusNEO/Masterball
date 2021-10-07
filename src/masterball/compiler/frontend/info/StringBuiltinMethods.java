package masterball.compiler.frontend.info;

import masterball.compiler.frontend.info.registry.FuncRegistry;
import masterball.compiler.frontend.info.registry.VarRegistry;
import masterball.compiler.frontend.info.scope.ClassScope;
import masterball.compiler.frontend.info.type.BaseType;

public class StringBuiltinMethods {
    public static ClassScope scope = new ClassScope();

    static {
        scope.register(
                new FuncRegistry("length", BaseType.BuiltinType.INT)
        );

        scope.register(
                new FuncRegistry("substring", BaseType.BuiltinType.STRING,
                        new VarRegistry("left", BaseType.BuiltinType.INT),
                        new VarRegistry("right", BaseType.BuiltinType.INT)
                )
        );

        scope.register(
                new FuncRegistry("parseInt", BaseType.BuiltinType.INT)
        );

        scope.register(
                new FuncRegistry("ord", BaseType.BuiltinType.INT,
                        new VarRegistry("pos", BaseType.BuiltinType.INT))
        );
    }
}
