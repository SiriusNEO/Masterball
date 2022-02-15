package masterball.debug;

public class Timer {

    private final long startTime;

    public Timer() {
        this.startTime = System.currentTimeMillis();
    }

    public void display() {
        System.out.println("total time: " + (System.currentTimeMillis() - startTime) + " (ms)");
    }

}
