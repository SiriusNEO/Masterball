package masterball.debug;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Log {

    public enum Verbose {off, all, infoOnly, markOnly, trackOnly, assertOnly};

    private static final String logHint = "<masterball log>: ";

    private static final Map<String, Integer> markCnt = new HashMap<>();

    private static final int InfoColor = 36, TrackColor = 32, MarkColor = 35;

    private static Verbose verbose;
    private static boolean infoOpen, markOpen, trackOpen;

    private static PrintStream ps = System.out;

    private static void colorPrintln(int color, String content){
        ps.format("\033[%dm%s\033[0m\n", color, content);
    }

    public static void setPrintStream(PrintStream ps) {
        Log.ps = ps;
    }

    public static void setVerbose(Verbose verbose) {
        Log.verbose = verbose;
        infoOpen = markOpen = trackOpen = false;

        if (verbose == Verbose.off) {
            return;
        }

        if (verbose == Verbose.all) {
            infoOpen = markOpen = trackOpen = true;
        }
        else {
            switch (verbose) {
                case infoOnly: infoOpen = true; break;
                case markOnly: markOpen = true; break;
                case trackOnly: trackOpen = true; break;
            }
        }
    }

    // --- info: show something ---

    public static void info(Object... vars) {
        if (!infoOpen) {
            return;
        }
        StringBuilder info = new StringBuilder(logHint + "[Info] ");
        for (Object var : vars) {
            info.append(var.toString());
            info.append(" ");
        }
        colorPrintln(InfoColor, info.toString());
    }

    public static void info(VarPair... vars) {
        if (!infoOpen) {
            return;
        }
        StringBuilder info = new StringBuilder(logHint + "[Info] ");
        for (VarPair var : vars) {
            info.append(var.toString());
            info.append(" ");
        }
        colorPrintln(InfoColor, info.toString());
    }

    // --- mark: place a mark ---

    public static void mark() {
        if (markOpen) {
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
        if (markOpen) {
            int nowCnt;
            if (!markCnt.containsKey(msg)) {
                nowCnt = 0;
                markCnt.put(msg, 1);
            }
            else {
                nowCnt = markCnt.get(msg);
                markCnt.put(msg, nowCnt + 1);
            }
            colorPrintln(MarkColor, logHint + "[Mark] mark " + msg + " " + nowCnt);
        }
    }

    public static void mark(String name, String msg) {
        if (markOpen) {
            mark(name + ": " + msg);
        }
    }

    public static void markReset() {
        if (markOpen) markCnt.remove(null);
    }

    public static void markReset(String msg) {
        if (markOpen) markCnt.remove(msg);
    }

    public static void markReset(String name, String msg) {
        if (markOpen) {
            markReset(name + ": " + msg);
        }
    }

    // --- track: track the behaviour ---

    public static void track(String msg) {
        if (!trackOpen) {
            return;
        }
        colorPrintln(TrackColor, logHint + "[Track] Tracking... " + msg);
    }

    public static void track(Object... vars) {
        if (!trackOpen) {
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
        if (Log.verbose == Verbose.off ) {
            return;
        }
        ps.println(logHint + "[StackTrace]");
        throwable.printStackTrace();
    }
}
