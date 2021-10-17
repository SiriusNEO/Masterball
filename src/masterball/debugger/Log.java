package masterball.debugger;

import java.io.*;

public class Log {
    private static int markCnt = 0;

    private static final boolean isOpen = false;

    private static PrintStream ps = System.out;

    public static void setPrintStream(PrintStream ps) {
        Log.ps = ps;
    }

    public static void report(Object var) {
        StringBuilder info = new StringBuilder("Log:[Report] ");
        info.append(var.toString());
        ps.println(info);
    }

    public static void report(VarPair... vars) {
        if (!isOpen) {
            return;
        }
        StringBuilder info = new StringBuilder("Log:[Report] ");
        for (VarPair var : vars) {
            info.append(var.toString());
            info.append(" ");
        }
        ps.println(info);
    }

    public static void mark() {
        if (isOpen) {
            ps.println("Log:[mark] mark " + markCnt);
            markCnt++;
        }
    }

    public static void track(String msg) {
        if (!isOpen) {
            return;
        }
        ps.println("Log:[Track] Tracking... " + msg);
    }

    public static void stackTrace(Throwable throwable) {
        if (!isOpen) {
            return;
        }
        ps.println("Log:[StackTrace]");
        throwable.printStackTrace();
    }
}
