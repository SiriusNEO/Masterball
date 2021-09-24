package masterball.engine;

import masterball.debugger.Log;
import masterball.debugger.VarPair;

import java.io.*;
import java.util.Objects;

public class IOEngine {

    public static final String redirectInput = "-i";
    public static final String redirectOutput = "-o";

    public final InputStream is;
    private final PrintStream os;

    public IOEngine(String[] args) throws Exception {
        String inputPath = null, outputPath = null;
        for (int i = 0; i < args.length; i++) {
            if (Objects.equals(args[i], redirectInput)) {
                if (i == args.length - 1) throw new FileNotFoundException();
                inputPath = args[i + 1];
                i ++;
            }
            else if (Objects.equals(args[i], redirectOutput)) {
                if (i == args.length - 1) throw new FileNotFoundException();
                outputPath = args[i + 1];
                i ++;
            }
        }
        is = (inputPath != null) ? new FileInputStream(inputPath) : System.in;
        os = (outputPath != null) ? new PrintStream(outputPath) : System.out;

        Log.track("IOEngine start successfully.");
        Log.report(new VarPair("is", is), new VarPair("os", os));
    }

    public void println(String s) {
        os.println(s);
    }
}