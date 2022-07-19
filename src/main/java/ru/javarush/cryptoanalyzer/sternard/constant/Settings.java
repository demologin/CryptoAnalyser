package ru.javarush.cryptoanalyzer.sternard.constant;

import java.io.File;

public class Settings {
    private static final char pathSeparator = File.separator.charAt(0);
    private static final String PATH_FROM_ROOT =
            "src/main/java/ru/javarush/cryptoanalyzer/sternard/".replace('/', pathSeparator);
    public static final String TEXT_DIRECTORY = "text";
    public static final String SOURCE_FILENAME = "text.txt";
    public static final String ENCRYPTED_FILENAME = "encrypted.txt";
    public static final String DECRYPTED_FILENAME = "decrypted.txt";
    public static final String LOG_FILENAME_EXCEPTIONS = "LogExceptions.txt";
    public static final String LOG_DATE_TIME_FORMAT = "dd.MM.yyyy HH:mm:ss";
    public static final boolean SHOW_STACKTRACE_ERRORS = false; // true - yes, false - no
    public static final boolean WRITE_TO_LOG_ERRORS = true; // true - yes, false - no
    public static final String LOGS_DIRECTORY = PATH_FROM_ROOT + "logs";
    public static final String INFORMATION_MESSAGE_ICON = PATH_FROM_ROOT + "images" + pathSeparator + "info.png";
}