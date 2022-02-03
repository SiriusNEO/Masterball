package masterball;

import masterball.compiler.backend.BackEnd;
import masterball.compiler.frontend.FrontEnd;
import masterball.compiler.middleend.MiddleEnd;
import masterball.compiler.share.error.CompileError;
import masterball.console.*;
import masterball.console.error.ConsoleError;

/*
 * @Masterball main entry
 * a Compiler for Mx* language
 * by SiriusNEO
 */

public class Masterball {

    public static void main(String[] args) throws Exception {
        try {
            Console console = new Console(args);

            if (console.showHelp || console.showVersion) return;

            FrontEnd frontEnd = new FrontEnd();

            if (console.fsyntaxOnly) return;

            MiddleEnd middleEnd = new MiddleEnd(frontEnd);

            if (console.irOnly) return;

            var start = System.currentTimeMillis();
            BackEnd backEnd = new BackEnd(middleEnd);
            System.out.println((System.currentTimeMillis() - start) / 1000);
        }
        catch (Exception e) {
            errorHandle(e);
        }
        System.exit(0);
    }

    private static void errorHandle(Exception e) {
        if (e instanceof CompileError) {
            ((CompileError) e).tell();
            throw new RuntimeException();
        }
        else if (e instanceof ConsoleError) {
            ((ConsoleError) e).tell();
            throw new RuntimeException();
        }
        else {
            e.printStackTrace();
        }
    }
}
