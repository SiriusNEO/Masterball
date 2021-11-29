package masterball.compiler.frontend.info.registry;

import masterball.compiler.frontend.info.CodePos;
import masterball.compiler.middleend.llvmir.hierarchy.BaseValue;
import org.antlr.v4.runtime.ParserRuleContext;

public abstract class BaseRegistry {
    public final String name;
    public final CodePos codePos;
    public BaseValue value;

    BaseRegistry(String name) {
        this.name = name;
        this.codePos = null;
    }

    BaseRegistry(String name, ParserRuleContext ctx) {
        this.name = name;
        this.codePos = new CodePos(ctx);
    }
}
