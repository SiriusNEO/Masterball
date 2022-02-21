package masterball.debug;

public class Timer {

    private static long startTime;

    public static void start() {
        startTime = System.currentTimeMillis();
    }

    public static long getTime() {
        return System.currentTimeMillis() - startTime;
    }

    public static void display() {
        Log.info("#timer#   total time: " + (System.currentTimeMillis() - startTime) + " (ms)");
    }

}
