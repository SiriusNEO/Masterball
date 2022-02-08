package masterball.debug;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Log {
    public static final String logHint = "<masterball log>: ";

    private static final Map<String, Integer> markCnt = new HashMap<>();

    private static final int ReportColor = 35, TrackColor = 32, MarkColor = 36;

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
        StringBuilder info = new StringBuilder(logHint + "[Report] ");
        info.append(var.toString());
        colorPrintln(ReportColor, info.toString());
    }

    public static void report(Object... vars) {
        if (!isOpen) {
            return;
        }
        StringBuilder info = new StringBuilder(logHint + "[Report] ");
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
        StringBuilder info = new StringBuilder(logHint + "[Report] ");
        for (VarPair var : vars) {
            info.append(var.toString());
            info.append(" ");
        }
        colorPrintln(ReportColor, info.toString());
    }

    public static void mark() {
        if (isOpen) {
            int nowCnt;
            if (!markCnt.containsKey(null)) {
                nowCnt = 0;
                markCnt.put(null, 1);
            }
            else {
                nowCnt = markCnt.get(null);
                markCnt.put(null, nowCnt + 1);
            }
            colorPrintln(MarkColor, logHint + "[Mark] mark " + nowCnt);
        }
    }

    public static void mark(String msg) {
        if (isOpen) {
            int nowCnt;
            if (!markCnt.containsKey(msg)) {
                nowCnt = 0;
                markCnt.put(msg, 1);
            }
            else {
                nowCnt = markCnt.get(msg);
                markCnt.put(msg, nowCnt + 1);
            }
            colorPrintln(MarkColor, logHint + "[Mark] mark " + nowCnt);
            colorPrintln(MarkColor, logHint + "[Mark] mark " + msg + " " + nowCnt);
        }
    }

    public static void markReset() {
        markCnt.remove(null);
    }

    public static void markReset(String msg) {
        markCnt.remove(msg);
    }

    public static void track(String msg) {
        if (!isOpen) {
            return;
        }
        colorPrintln(TrackColor, logHint + "[Track] Tracking... " + msg);
    }

    public static void track(Object... vars) {
        if (!isOpen) {
            return;
        }
        StringBuilder info = new StringBuilder(logHint + "[Track] Tracking... ");
        for (Object var : vars) {
            info.append(var.toString());
            info.append(" ");
        }
        colorPrintln(TrackColor, info.toString());
    }

    public static void stackTrace(Throwable throwable) {
        if (!isOpen) {
            return;
        }
        ps.println(logHint + "[StackTrace]");
        throwable.printStackTrace();
    }
}
