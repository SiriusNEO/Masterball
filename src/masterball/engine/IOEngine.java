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
    private static final String redirectRVOutput = "-rv-o";
    private static final String semanticCheckOnly = "-fsyntax-only";

    public String inputPath = null, logOutputPath = null, astOutputPath = null, llvmOutputPath = null, rvOutputPath = null;

    public final InputStream is;
    public final PrintStream logStream, astGenStream, irGenStream, asmGenStream;

    public boolean fsyntaxOnly = false;

    public static String getFileName(String path) {
        if (path == null) return "test";
        for (int i = path.length()-1; i >= 0; i--) {
            if (path.charAt(i) == '/') {
                return path.substring(i+1, path.length());
            }
        }
        return path;
    }

    // IO Parser
    public IOEngine(String[] args) throws Exception {
        for (int i = 0; i < args.length; i++) {
            if (Objects.equals(args[i], semanticCheckOnly)) {
                fsyntaxOnly = true;
            }
            else if (Objects.equals(args[i], redirectInput)) {
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
            else if (Objects.equals(args[i], redirectRVOutput)) {
                if (i == args.length - 1) throw new FileNotFoundException();
                rvOutputPath = args[i + 1];
                i ++;
            }
        }

        is = (inputPath != null) ? new FileInputStream(inputPath) : System.in;
        logStream = (logOutputPath != null) ? new PrintStream(logOutputPath) : System.out;
        astGenStream = (astOutputPath != null) ? new PrintStream(astOutputPath) : System.out;
        irGenStream = (llvmOutputPath != null) ? new PrintStream(llvmOutputPath) : System.out;
        asmGenStream = (rvOutputPath != null) ? new PrintStream(rvOutputPath) : System.out;

        Log.setPrintStream(logStream);

        Log.track("IOEngine started successfully.");
    }
}