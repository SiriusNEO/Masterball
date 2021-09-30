package masterball.compiler.frontend.info;

import masterball.compiler.frontend.parser.MxStarParser;
import masterball.compiler.frontend.scope.ClassScope;

import java.util.HashMap;

public class ClassRegistry extends Registry {

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
