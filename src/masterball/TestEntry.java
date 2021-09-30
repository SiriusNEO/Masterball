package masterball;

import masterball.compiler.frontend.error.BaseError;
import masterball.compiler.frontend.error.SyntaxError;
import masterball.debugger.ASTPrinter;
import masterball.debugger.Log;
import masterball.engine.IOEngine;
import masterball.engine.ParseEngine;
import masterball.engine.SemanticEngine;

import java.util.HashMap;

public class TestEntry {

    public static void main(String[] args) throws Exception {
        Log.track("Test Func Start...");
        
        try {
            IOEngine ioEngine = new IOEngine(args);

            ParseEngine parseEngine = new ParseEngine(ioEngine);

            SemanticEngine semanticEngine = new SemanticEngine(parseEngine);

            new ASTPrinter().visit(semanticEngine.ASTRoot);
        }
        catch (Exception e) {
            if (e instanceof BaseError) {
                ((BaseError) e).tell();
            } else {
                e.printStackTrace();
            }
            return;
        }
    }

}
