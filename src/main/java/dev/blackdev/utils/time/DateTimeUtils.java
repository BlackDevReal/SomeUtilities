package dev.blackdev.utils.time;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
    public static String now() {
        return LocalDateTime.now().toString();
    }

    public static String format(LocalDateTime dateTime, String pattern) {
        return dateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static long daysBetween(LocalDate d1, LocalDate d2) {
        return Duration.between(d1.atStartOfDay(), d2.atStartOfDay()).toDays();
    }
}