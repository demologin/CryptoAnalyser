package ru.javarush.cryptoanalyzer.cherepovskiy.exceptions;

import ru.javarush.cryptoanalyzer.cherepovskiy.entity.ResultCode;

public class AppException extends RuntimeException {
    public AppException() {
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(Throwable cause) {
        super(cause);
    }

    public AppException(ResultCode error, String message) {
    }
}
