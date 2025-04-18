package dev.blackdev.utils.mock;

import java.util.UUID;

public class MockDataUtils {
    public static String randomEmail() {
        return "user" + UUID.randomUUID().toString().substring(0, 8) + "@example.com";
    }

    public static String randomUsername() {
        return "user_" + UUID.randomUUID().toString().substring(0, 6);
    }

    public static String randomString(int length) {
        return UUID.randomUUID().toString().replace("-", "").substring(0, length);
    }
}