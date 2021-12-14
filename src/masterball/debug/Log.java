package masterball.debug;

import java.io.*;

public class Log {
    private static int markCnt = 0;
    private static final int ReportColor = 35, TrackColor = 32, MarkColor = 33;

    private static final boolean isOpen = false;

    private static PrintStream ps = System.out;

    private static void colorPrintln(int color, String content){
        ps.format("\033[%dm%s\033[0m\n", color, content);
    }

    public static void setPrintStream(PrintStream ps) {
        Log.ps = ps;
    }

    public static void report(Object var) {
        if (!isOpen) {
            return;
        }
        StringBuilder info = new StringBuilder("Log:[Report] ");
        info.append(var.toString());
        colorPrintln(ReportColor, info.toString());
    }

    public static void report(Object... vars) {
        if (!isOpen) {
            return;
        }
        StringBuilder info = new StringBuilder("Log:[Report] ");
        for (Object var : vars) {
            info.append(var.toString());
            info.append(" ");
        }
        colorPrintln(ReportColor, info.toString());
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
        colorPrintln(ReportColor, info.toString());
    }

    public static void mark() {
        if (isOpen) {
            colorPrintln(MarkColor, "Log:[Mark] mark " + markCnt);
            markCnt++;
        }
    }

    public static void track(String msg) {
        if (!isOpen) {
            return;
        }
        colorPrintln(TrackColor, "Log:[Track] Tracking... " + msg);
    }

    public static void stackTrace(Throwable throwable) {
        if (!isOpen) {
            return;
        }
        ps.println("Log:[StackTrace]");
        throwable.printStackTrace();
    }
}
