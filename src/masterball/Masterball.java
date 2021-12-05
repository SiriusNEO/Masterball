package masterball;

import masterball.compiler.utils.error.BaseError;
import masterball.engine.IOEngine;
import masterball.engine.IRGenEngine;
import masterball.engine.ParseEngine;
import masterball.engine.SemanticEngine;

// Masterball main entry. GAMESTART.

public class Masterball {

    public static void main(String[] args) throws Exception {

        try {
            // sequential compiler progress

            IOEngine ioEngine = new IOEngine(args);

            ParseEngine parseEngine = new ParseEngine(ioEngine);

            SemanticEngine semanticEngine = new SemanticEngine(parseEngine, ioEngine.astGenStream);

            IRGenEngine irGenEngine = new IRGenEngine(semanticEngine, true, ioEngine.irGenStream);
        }
        catch (Exception e) {
            if (e instanceof BaseError) {
            //  ((BaseError) e).tell();
                System.exit(-1);
            } else {
            //  e.printStackTrace();
                System.exit(-1);
            }
        }

        // System.out.println("Success.");
    }

}
