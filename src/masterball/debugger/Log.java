package masterball.debugger;

import java.io.OutputStream;
import java.io.PrintStream;

public class Log {
    private static final boolean isOpen = true;

    private final PrintStream ps;

    public Log(PrintStream ps) {
        this.ps = ps;
        ps.println("Hello, the Log is open now.");
    }

    public void report(VarPair... vars) {
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

    public void track(String msg) {
        if (!isOpen) {
            return;
        }
        ps.println("Log:[Track] Tracking... " + msg);
    }

    public void stackTrace(Throwable throwable) {
        if (!isOpen) {
            return;
        }
        ps.println("Log:[StackTrace]");
        throwable.printStackTrace();
    }
}
