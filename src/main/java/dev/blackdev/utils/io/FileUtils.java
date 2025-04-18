package dev.blackdev.utils.io;

import java.io.*;
import java.nio.file.*;

public class FileUtils {
    public static String readFile(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    public static void writeFile(String path, String content) throws IOException {
        Files.write(Paths.get(path), content.getBytes());
    }
}