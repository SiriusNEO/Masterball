package masterball.debug;

import java.util.HashMap;
import java.util.Map;

public class Statistics {

    private static final Map<String, Integer> cnt = new HashMap<>();

    public static void plus(String name) {
        cnt.putIfAbsent(name, 0);
        cnt.put(name, cnt.get(name)+1);
    }

    public static void plus(String name, int value) {
        cnt.putIfAbsent(name, 0);
        cnt.put(name, cnt.get(name)+value);
    }

    public static void show(String name) {

        if (!cnt.containsKey(name))
            Log.info("#statistics# not found!");
        else
            Log.info("#statistics# <" + name + "> total = " + cnt.get(name));
    }

}
