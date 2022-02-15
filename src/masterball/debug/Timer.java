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
        System.out.println("total time: " + (System.currentTimeMillis() - startTime) + " (ms)");
    }

}
