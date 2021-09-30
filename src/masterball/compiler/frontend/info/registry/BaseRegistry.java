package masterball.compiler.frontend.info.registry;

import masterball.compiler.frontend.info.CodePos;
import org.antlr.v4.runtime.ParserRuleContext;

public abstract class BaseRegistry {
    public final String name;
    public final CodePos codePos;

    BaseRegistry(String name, ParserRuleContext ctx) {
        this.name = name;
        this.codePos = new CodePos(ctx);
    }
}
