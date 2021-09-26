package masterball.compiler.frontend.info;

import org.antlr.v4.runtime.ParserRuleContext;

public abstract class Registry {
    public final String name;
    public final CodePos codePos;

    Registry(String name, ParserRuleContext ctx) {
        this.name = name;
        this.codePos = new CodePos(ctx);
    }
}
