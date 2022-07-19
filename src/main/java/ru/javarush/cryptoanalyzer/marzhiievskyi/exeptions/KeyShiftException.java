package ru.javarush.cryptoanalyzer.marzhiievskyi.exeptions;

public class KeyShiftException extends RuntimeException{
    public KeyShiftException() {
    }

    public KeyShiftException(String message) {
        super(message);
    }

    public KeyShiftException(String message, Throwable cause) {
        super(message, cause);
    }

    public KeyShiftException(Throwable cause) {
        super(cause);
    }
}
