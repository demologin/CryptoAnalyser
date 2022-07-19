package ru.javarush.cryptoanalyser.sternard.util;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static ru.javarush.cryptoanalyser.sternard.constant.Settings.LOGS_DIRECTORY;
import static ru.javarush.cryptoanalyser.sternard.constant.Settings.TEXT_DIRECTORY;

public class PathFinder {
    public static String getTextDirectory() {
        return System.getProperty("user.dir") + File.separator + TEXT_DIRECTORY + File.separator;
    }

    public static Path getLogExceptionsDirectory() {
        return Paths.get(LOGS_DIRECTORY).toAbsolutePath();
    }
}