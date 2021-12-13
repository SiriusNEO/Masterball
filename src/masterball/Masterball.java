package masterball;

import masterball.compiler.share.error.BaseError;
import masterball.engine.*;

/*
 * @Masterball main entry
 * a Compiler for Mx* language
 * by SiriusNEO
 */

public class Masterball {

    public static void main(String[] args) throws Exception {
        try {
            IOEngine ioEngine = new IOEngine(args);

            ParseEngine parseEngine = new ParseEngine(ioEngine);

            SemanticEngine semanticEngine = new SemanticEngine(parseEngine, ioEngine.astGenStream);

            IRGenEngine irGenEngine = new IRGenEngine(semanticEngine, ioEngine);

            CodeGenEngine codeGenEngine = new CodeGenEngine(irGenEngine, ioEngine);
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
