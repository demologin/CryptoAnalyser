package ru.javarush.cryptoanalyser.sternard.exceptions;

import ru.javarush.cryptoanalyser.sternard.application.ReaderWriter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static ru.javarush.cryptoanalyser.sternard.constant.Settings.LOG_DATE_TIME_FORMAT;
import static ru.javarush.cryptoanalyser.sternard.constant.Settings.LOG_FILENAME_EXCEPTIONS;
import static ru.javarush.cryptoanalyser.sternard.util.PathFinder.getLogExceptionsDirectory;

public class WriteToLogs {
    protected void writeToLogFileException(String message, StackTraceElement[] stackTrace) {
        String dateTime = DateTimeFormatter.ofPattern(LOG_DATE_TIME_FORMAT).format(LocalDateTime.now());
        StringBuilder str = new StringBuilder(dateTime + " : " + message + "\n");
        for (StackTraceElement txt : stackTrace) {
            str.append(txt).append("\n");
        }
        str.append("-".repeat(100)).append("\n");
        new ReaderWriter().writer(String.valueOf(getLogExceptionsDirectory().resolve(LOG_FILENAME_EXCEPTIONS)),
                String.valueOf(str), true);
    }
}