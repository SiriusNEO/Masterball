package masterball;

import masterball.debugger.Log;
import masterball.engine.IOEngine;
import masterball.engine.ParseEngine;

public class Masterball {
    public static void main(String[] args) throws Exception {
        IOEngine ioEngine = new IOEngine(args);
        ParseEngine parseEngine = new ParseEngine(ioEngine.is);
    }

}
