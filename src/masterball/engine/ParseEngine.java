package masterball.engine;

import masterball.compiler.utils.error.ParseErrorListener;
import masterball.compiler.frontend.parser.MxStarLexer;
import masterball.compiler.frontend.parser.MxStarParser;
import masterball.debug.Log;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class ParseEngine {

    public final MxStarLexer mxStarLexer;
    public final MxStarParser mxStarParser;
    public final ParseTree parseTreeRoot;

    public ParseEngine(IOEngine ioe) throws Exception {
        mxStarLexer = new MxStarLexer(CharStreams.fromStream(ioe.is));
        mxStarLexer.removeErrorListeners();
        mxStarLexer.addErrorListener(new ParseErrorListener());
        
        mxStarParser = new MxStarParser(new CommonTokenStream(mxStarLexer));
        mxStarParser.removeErrorListeners();
        mxStarParser.addErrorListener(new ParseErrorListener());

        parseTreeRoot = mxStarParser.mxStarCode();

        Log.track("ParseEngine started successfully.");
    }

}
