package masterball;

import masterball.compiler.share.error.BaseError;
import masterball.engine.*;

public class TestEntry {

    public static void main(String[] args) throws Exception {
        try {
            IOEngine ioEngine = new IOEngine(args);

            ParseEngine parseEngine = new ParseEngine(ioEngine);

            SemanticEngine semanticEngine = new SemanticEngine(parseEngine, ioEngine.astGenStream);

            IRGenEngine irGenEngine = new IRGenEngine(semanticEngine, true, ioEngine.irGenStream);

            CodeGenEngine codeGenEngine = new CodeGenEngine(irGenEngine, ioEngine.asmGenStream);
        }
        catch (Exception e) {
            if (e instanceof BaseError) {
                ((BaseError) e).tell();
            }
            e.printStackTrace();
            return;
        }
    }

}
