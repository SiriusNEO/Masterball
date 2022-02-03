package masterball.compiler.frontend;

import masterball.compiler.frontend.ast.ASTBuilder;
import masterball.compiler.frontend.ast.ASTPrinter;
import masterball.compiler.frontend.ast.node.RootNode;
import masterball.compiler.frontend.parser.MxStarLexer;
import masterball.compiler.frontend.parser.MxStarParser;
import masterball.compiler.frontend.sema.SemanticChecker;
import masterball.compiler.share.error.ParseErrorListener;
import masterball.debug.Log;
import masterball.console.Console;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class FrontEnd {
    public final RootNode ASTRoot;

    private final MxStarLexer mxStarLexer;
    private final MxStarParser mxStarParser;
    private final ParseTree parseTreeRoot;

    public FrontEnd(Console console) throws Exception {
        // lexer
        mxStarLexer = new MxStarLexer(CharStreams.fromStream(console.inputStream));
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
        if (console.astOutputStream != null)
            new ASTPrinter(console.astOutputStream).visit(this.ASTRoot);

        Log.track("FrontEnd started successfully.");
    }

}
