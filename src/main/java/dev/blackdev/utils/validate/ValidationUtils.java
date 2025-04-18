package dev.blackdev.utils.validate;

import java.util.regex.Pattern;

public class ValidationUtils {
    private static final Pattern EMAIL = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public static boolean isValidEmail(String email) {
        return EMAIL.matcher(email).matches();
    }

    private static final Pattern UUID_PATTERN =
            Pattern.compile("^[a-fA-F0-9]{8}\\-[a-fA-F0-9]{4}\\-[a-fA-F0-9]{4}\\-[a-fA-F0-9]{4}\\-[a-fA-F0-9]{12}$");

    public static boolean isUUID(String str) {
        return UUID_PATTERN.matcher(str).matches();
    }

}
