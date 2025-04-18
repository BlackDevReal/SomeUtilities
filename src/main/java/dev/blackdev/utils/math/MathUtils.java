package dev.blackdev.utils.math;

import java.util.Arrays;
import java.util.Random;

public class MathUtils {
    private static final Random random = new Random();

    // --- BASIC MATH ---

    public static int clamp(int val, int min, int max) {
        return Math.max(min, Math.min(max, val));
    }

    public static double clamp(double val, double min, double max) {
        return Math.max(min, Math.min(max, val));
    }

    public static int abs(int val) {
        return Math.abs(val);
    }

    public static double abs(double val) {
        return Math.abs(val);
    }

    public static int sign(int val) {
        return Integer.compare(val, 0);
    }

    public static double sign(double val) {
        return Math.signum(val);
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static boolean isOdd(int n) {
        return n % 2 != 0;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    // --- RANDOM HELPERS ---

    public static int randInt(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public static double randDouble(double min, double max) {
        return min + (max - min) * random.nextDouble();
    }

    public static boolean chance(double probability) {
        return random.nextDouble() < probability;
    }

    // --- INTERPOLATION / EASING ---

    public static double lerp(double a, double b, double t) {
        return a + t * (b - a);
    }

    public static double invLerp(double a, double b, double value) {
        return (value - a) / (b - a);
    }

    public static double remap(double value, double inMin, double inMax, double outMin, double outMax) {
        return lerp(outMin, outMax, invLerp(inMin, inMax, value));
    }

    // --- GEOMETRY ---

    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.hypot(x2 - x1, y2 - y1);
    }

    public static double angleBetween(double x1, double y1, double x2, double y2) {
        return Math.toDegrees(Math.atan2(y2 - y1, x2 - x1));
    }

    public static double degToRad(double deg) {
        return Math.toRadians(deg);
    }

    public static double radToDeg(double rad) {
        return Math.toDegrees(rad);
    }

    // --- STATISTICS ---

    public static double mean(double[] values) {
        return Arrays.stream(values).average().orElse(Double.NaN);
    }

    public static double median(double[] values) {
        double[] sorted = values.clone();
        Arrays.sort(sorted);
        int middle = sorted.length / 2;
        return sorted.length % 2 == 0
                ? (sorted[middle - 1] + sorted[middle]) / 2.0
                : sorted[middle];
    }

    public static double variance(double[] values) {
        double mean = mean(values);
        return Arrays.stream(values).map(v -> (v - mean) * (v - mean)).average().orElse(Double.NaN);
    }

    public static double stdDev(double[] values) {
        return Math.sqrt(variance(values));
    }

    public static double min(double[] values) {
        return Arrays.stream(values).min().orElse(Double.NaN);
    }

    public static double max(double[] values) {
        return Arrays.stream(values).max().orElse(Double.NaN);
    }

    public static double sum(double[] values) {
        return Arrays.stream(values).sum();
    }

    // --- MISC ---

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static int nextPowerOfTwo(int n) {
        if (n <= 0) return 1;
        return Integer.highestOneBit(n - 1) << 1;
    }

    public static int factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative factorial not defined.");
        int result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }

    public static long fibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative fibonacci not defined.");
        if (n == 0) return 0;
        if (n == 1) return 1;
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
