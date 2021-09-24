package masterball.debugger;

import java.io.*;

public class Log {
    private static final boolean isOpen = true;

    private static final PrintStream ps = System.out;

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
