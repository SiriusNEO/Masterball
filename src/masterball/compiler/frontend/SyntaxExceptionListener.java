package masterball.compiler.frontend;

import masterball.compiler.frontend.exception.CodePos;
import masterball.compiler.frontend.exception.SyntaxException;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class SyntaxExceptionListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line, int charPositionInLine,
                            String message,
                            RecognitionException exception) {
        throw new SyntaxException(new CodePos(line, charPositionInLine), message);
    }
}
