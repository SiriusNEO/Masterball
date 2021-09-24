package masterball.compiler.frontend.exception;

import org.antlr.v4.runtime.Token;

public class CodePos {
    private final int codeLine, codePosInline;

    public CodePos(int codeLine, int codePosInline) {
        this.codeLine = codeLine;
        this.codePosInline = codePosInline;
    }

    public CodePos(Token token) {
        this.codeLine = token.getLine();
        this.codePosInline = token.getCharPositionInLine();
    }

    public String toString() { return " in line:" + codeLine + ", pos:" + codePosInline; }
}
