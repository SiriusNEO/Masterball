package masterball;

import masterball.compiler.middleend.IRPrinter;
import masterball.compiler.utils.error.BaseError;
import masterball.compiler.frontend.ASTPrinter;
import masterball.debug.Log;
import masterball.engine.IOEngine;
import masterball.engine.IRGenEngine;
import masterball.engine.ParseEngine;
import masterball.engine.SemanticEngine;

public class TestEntry {

    public static void main(String[] args) throws Exception {
        Log.track("Test Func Start...");
        try {
            IOEngine ioEngine = new IOEngine(args);

            ParseEngine parseEngine = new ParseEngine(ioEngine);

            SemanticEngine semanticEngine = new SemanticEngine(parseEngine, true);

            IRGenEngine irGenEngine = new IRGenEngine(semanticEngine, true, true);
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
