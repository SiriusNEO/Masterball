package darksword;

import darksword.interpreter.LLVMReader;
import masterball.console.Config;
import masterball.console.Console;
import masterball.console.error.ConsoleError;
import masterball.debug.Timer;

import java.io.InputStream;

public class DarkSwordVM {

    public static void main(String[] args) throws Exception {
        try {
            Timer.start();

            Console console = new Console(args);
            if (console.showHelp || console.showVersion) return;

            new LLVMReader((InputStream) Config.getArgValue(Config.Option.Input)).read();

            Timer.display();
        }
        catch (Exception e) {
            errorHandle(e);
        }
        System.exit(0);
    }

    private static void errorHandle(Exception e) {
        if (e instanceof ConsoleError) {
            ((ConsoleError) e).tell();
            throw new RuntimeException();
        }
        else {
            e.printStackTrace();
        }
    }
}
