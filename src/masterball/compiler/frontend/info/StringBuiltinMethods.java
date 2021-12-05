package masterball.compiler.frontend.info;

import masterball.compiler.frontend.info.registry.FuncRegistry;
import masterball.compiler.frontend.info.registry.VarRegistry;
import masterball.compiler.frontend.info.scope.ClassScope;
import masterball.compiler.frontend.info.type.MxBaseType;
import masterball.compiler.utils.MxStarTable;

public class StringBuiltinMethods {
    public static ClassScope scope = new ClassScope();

    static {
        scope.register(
                new FuncRegistry(MxStarTable.StrBuiltinLength, MxBaseType.BuiltinType.INT)
        );

        scope.register(
                new FuncRegistry(MxStarTable.StrBuiltinSubstring, MxBaseType.BuiltinType.STRING,
                        new VarRegistry("left", MxBaseType.BuiltinType.INT),
                        new VarRegistry("right", MxBaseType.BuiltinType.INT)
                )
        );

        scope.register(
                new FuncRegistry(MxStarTable.StrBuiltinParseInt, MxBaseType.BuiltinType.INT)
        );

        scope.register(
                new FuncRegistry(MxStarTable.StrBuiltinOrd, MxBaseType.BuiltinType.INT,
                        new VarRegistry("pos", MxBaseType.BuiltinType.INT))
        );
    }
}
