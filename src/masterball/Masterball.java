package masterball;

import masterball.compiler.frontend.error.BaseError;
import masterball.compiler.frontend.error.SyntaxError;
import masterball.debugger.ASTPrinter;
import masterball.debugger.Log;
import masterball.engine.IOEngine;
import masterball.engine.ParseEngine;
import masterball.engine.SemanticEngine;

import java.io.PrintStream;
import java.util.HashMap;

public class Masterball {

    public static void main(String[] args) throws Exception {

        try {
            IOEngine ioEngine = new IOEngine(args);

            ParseEngine parseEngine = new ParseEngine(ioEngine);

            SemanticEngine semanticEngine = new SemanticEngine(parseEngine);
        }
        catch (Exception e) {
            if (e instanceof BaseError) {
            //  ((BaseError) e).tell();
                System.exit(-1);
            } else {
            //  e.printStackTrace();
                System.exit(-1);
            }
            return;
        }

        // System.out.println("Success.");
    }

}
