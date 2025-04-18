package dev.blackdev.utils.dev;

import java.util.*;

public class TimerUtils {
    private static final Map<String, Long> timers = new HashMap<>();

    public static void start(String label) {
        timers.put(label, System.currentTimeMillis());
    }

    public static void end(String label) {
        Long start = timers.get(label);
        if (start != null) {
            long duration = System.currentTimeMillis() - start;
            System.out.println(label + " took " + duration + " ms");
            timers.remove(label);
        }
    }
}