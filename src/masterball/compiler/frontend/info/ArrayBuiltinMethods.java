package masterball.compiler.frontend.info;

import masterball.compiler.frontend.info.registry.FuncRegistry;
import masterball.compiler.frontend.info.scope.ClassScope;
import masterball.compiler.frontend.info.type.MxBaseType;
import masterball.compiler.share.MxStarTable;

public class ArrayBuiltinMethods {

    public static ClassScope scope = new ClassScope();

    static {
        scope.register(
                new FuncRegistry(MxStarTable.ArrayBuiltinSize, MxBaseType.BuiltinType.INT)
        );
    }

}
