package masterball.compiler.frontend.error;

import masterball.compiler.frontend.info.CodePos;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class ParseErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line, int charPositionInLine,
                            String message,
                            RecognitionException exception) {
        throw new SyntaxError(new CodePos(line, charPositionInLine), message, "Parse Failed");
    }
}
