package masterball.engine;

import masterball.compiler.frontend.SyntaxExceptionListener;
import masterball.compiler.frontend.parser.MxStarLexer;
import masterball.compiler.frontend.parser.MxStarParser;
import masterball.debugger.Log;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.io.InputStream;

public class ParseEngine {

    public final MxStarLexer mxStarLexer;
    public final MxStarParser mxStarParser;
    public final ParseTree parseTreeRoot;

    public ParseEngine(InputStream is) throws Exception {
        mxStarLexer = new MxStarLexer(CharStreams.fromStream(is));
        mxStarLexer.removeErrorListeners();
        mxStarLexer.addErrorListener(new SyntaxExceptionListener());

        mxStarParser = new MxStarParser(new CommonTokenStream(mxStarLexer));
        mxStarParser.removeErrorListeners();
        mxStarParser.addErrorListener(new SyntaxExceptionListener());

        parseTreeRoot = mxStarParser.mxStarCode();

        Log.track("ParseEngine start successfully.");
    }

}
