package masterball.compiler.frontend;

import masterball.compiler.frontend.ast.ASTBuilder;
import masterball.compiler.frontend.ast.ASTPrinter;
import masterball.compiler.frontend.ast.node.RootNode;
import masterball.compiler.frontend.parser.MxStarLexer;
import masterball.compiler.frontend.parser.MxStarParser;
import masterball.compiler.frontend.sema.SemanticChecker;
import masterball.compiler.share.error.ParseErrorListener;
import masterball.console.Config;
import masterball.debug.Log;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.InputStream;
import java.io.PrintStream;

public class FrontEnd {
    public final RootNode ASTRoot;

    private final MxStarLexer mxStarLexer;
    private final MxStarParser mxStarParser;
    private final ParseTree parseTreeRoot;

    public FrontEnd() throws Exception {
        // lexer
        mxStarLexer = new MxStarLexer(CharStreams.fromStream(
                (InputStream) Config.getArgValue(Config.Option.Input)
        ));
        mxStarLexer.removeErrorListeners();
        mxStarLexer.addErrorListener(new ParseErrorListener());

        // parser
        mxStarParser = new MxStarParser(new CommonTokenStream(mxStarLexer));
        mxStarParser.removeErrorListeners();
        mxStarParser.addErrorListener(new ParseErrorListener());

        parseTreeRoot = mxStarParser.mxStarCode();

        // ASTBuilder
        this.ASTRoot = (RootNode) new ASTBuilder().visit(parseTreeRoot);

        // Semantic Check
        new SemanticChecker().visit(this.ASTRoot);

        // AST Printer
        new ASTPrinter(
                (PrintStream) Config.getArgValue(Config.Option.ASTOutput)
        ).visit(this.ASTRoot);

        Log.track("FrontEnd started successfully.");
    }

}
