package masterball.engine;

import masterball.debug.Log;
import masterball.debug.VarPair;

import java.io.*;
import java.util.Objects;

public class IOEngine {

    // Arguments
    private static final String redirectInput = "-i";
    private static final String redirectLogOutput = "-debug-o";
    private static final String redirectASTOutput = "-ast-o";
    private static final String redirectLLVMOutput = "-llvm-o";
    private static final String semanticCheckOnly = "-fsyntax-only";

    public final InputStream is;

    public final PrintStream logStream, astGenStream, irGenStream;

    public IOEngine(String[] args) throws Exception {

        String inputPath = null, logOutputPath = null, astOutputPath = null, llvmOutputPath = null;
        for (int i = 0; i < args.length; i++) {
            if (Objects.equals(args[i], redirectInput)) {
                if (i == args.length - 1) throw new FileNotFoundException();
                inputPath = args[i + 1];
                i ++;
            }
            else if (Objects.equals(args[i], redirectLogOutput)) {
                if (i == args.length - 1) throw new FileNotFoundException();
                logOutputPath = args[i + 1];
                i ++;
            }
            else if (Objects.equals(args[i], redirectASTOutput)) {
                if (i == args.length - 1) throw new FileNotFoundException();
                astOutputPath = args[i + 1];
                i ++;
            }
            else if (Objects.equals(args[i], redirectLLVMOutput)) {
                if (i == args.length - 1) throw new FileNotFoundException();
                llvmOutputPath = args[i + 1];
                i ++;
            }
        }

        is = (inputPath != null) ? new FileInputStream(inputPath) : System.in;
        logStream = (logOutputPath != null) ? new PrintStream(logOutputPath) : System.out;
        astGenStream = (astOutputPath != null) ? new PrintStream(astOutputPath) : System.out;
        irGenStream = (llvmOutputPath != null) ? new PrintStream(llvmOutputPath) : System.out;

        Log.setPrintStream(logStream);

        Log.track("IOEngine started successfully.");
        Log.report(new VarPair(redirectInput, is), new VarPair(redirectLLVMOutput, irGenStream));
    }
}