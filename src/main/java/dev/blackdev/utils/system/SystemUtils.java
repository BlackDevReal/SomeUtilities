package dev.blackdev.utils.system;

public class SystemUtils {
    public static String osName() {
        return System.getProperty("os.name");
    }

    public static long memoryUsed() {
        Runtime rt = Runtime.getRuntime();
        return rt.totalMemory() - rt.freeMemory();
    }
}