package masterball.compiler.frontend.info.registry;

import masterball.compiler.frontend.parser.MxStarParser;
import masterball.compiler.frontend.info.scope.ClassScope;

public class ClassRegistry extends BaseRegistry {

    public ClassScope scope;

    public ClassRegistry(MxStarParser.ClassDefContext ctx) {
        super(ctx.Identifier().toString(), ctx);
        this.scope = new ClassScope();
    }

    public String toString() {
        StringBuilder ret = new StringBuilder("[ClassRegistry] ");
        ret.append("\nname:" + name + " ");
        ret.append("\nscope:" + scope + " ");
        return ret.toString();
    }
}
