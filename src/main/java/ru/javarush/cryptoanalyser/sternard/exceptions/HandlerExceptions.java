package ru.javarush.cryptoanalyser.sternard.exceptions;

import static ru.javarush.cryptoanalyser.sternard.constant.Settings.SHOW_STACKTRACE_ERRORS;
import static ru.javarush.cryptoanalyser.sternard.constant.Settings.WRITE_TO_LOG_ERRORS;
import static ru.javarush.cryptoanalyser.sternard.util.ConsoleColors.RED_BOLD_BRIGHT;
import static ru.javarush.cryptoanalyser.sternard.util.ConsoleColors.RESET;

public class HandlerExceptions extends RuntimeException {
    public HandlerExceptions(String message) {
        showStackTraceOrNo(message);
    }

    public HandlerExceptions(String message, StackTraceElement[] stackTrace) {
        if (WRITE_TO_LOG_ERRORS)
            new WriteToLogs().writeToLogFileException(message, stackTrace);
        showStackTraceOrNo(message);
    }


    private void showStackTraceOrNo(String message) {
        if (!SHOW_STACKTRACE_ERRORS) {
            System.out.println(RED_BOLD_BRIGHT + message + RESET);
            System.exit(0); // остановка программы, чтобы не показывать стектрейс
        } else {
            System.out.println(RED_BOLD_BRIGHT + message + RESET);
        }
    }

}