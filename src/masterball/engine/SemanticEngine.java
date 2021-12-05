package masterball.engine;

import masterball.compiler.frontend.ASTBuilder;
import masterball.compiler.frontend.ASTPrinter;
import masterball.compiler.frontend.SemanticChecker;
import masterball.compiler.frontend.ast.node.RootNode;
import masterball.debug.Log;

import java.io.PrintStream;

public class SemanticEngine {
    public final RootNode ASTRoot;

    public SemanticEngine(ParseEngine pe, PrintStream astGenStream) {
        this.ASTRoot = (RootNode) new ASTBuilder().visit(pe.parseTreeRoot);

        new SemanticChecker().visit(this.ASTRoot);

        if (astGenStream != null) new ASTPrinter(astGenStream).visit(this.ASTRoot);

        Log.track("SemanticEngine started successfully.");
    }
}
