package masterball.compiler.share.warn;

public class Warning {

    private static final int WarningColor = 33;

    public String message;

    public Warning(String message) {
        this.message = message;
    }

    public void tell() {System.err.println("\033[" + WarningColor + "m<masterball compiler>: [Warning] " + message + "\033[0m");}

}
