package masterball.engine;

import masterball.compiler.frontend.ASTBuilder;
import masterball.compiler.frontend.ast.node.BaseNode;
import masterball.compiler.frontend.ast.node.RootNode;
import masterball.debugger.Log;

public class SemanticEngine {
    public final RootNode ASTRoot;

    public SemanticEngine(ParseEngine pe) {
        this.ASTRoot = (RootNode) new ASTBuilder().visit(pe.parseTreeRoot);

        Log.track("SemanticEngine started successfully.");
    }
}
