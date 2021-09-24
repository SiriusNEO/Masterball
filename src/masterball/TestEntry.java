package masterball;

import masterball.compiler.frontend.exception.SyntaxException;
import masterball.debugger.Log;
import masterball.engine.IOEngine;
import masterball.engine.ParseEngine;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;

public class TestEntry {

    public static void main(String[] args) throws Exception {
        Log.track("Test Func Start...");
        try {
            IOEngine ioEngine = new IOEngine(args);
            ParseEngine parseEngine = new ParseEngine(ioEngine.is);
        }
        catch (SyntaxException e) {
            e.tell();
            return;
        }
        catch (Exception e) {
            System.err.println();
            return;
        }
    }

}
