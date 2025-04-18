package dev.blackdev.utils.string;

public class StringUtils {
    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static String toSlug(String input) {
        return input.toLowerCase().replaceAll("[^a-z0-9]+", "-").replaceAll("(^-|-$)", "");
    }
}
