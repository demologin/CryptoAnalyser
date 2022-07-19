package ru.javarush.cryptoanalyser.zamaraev.exception;

public class ApplictionException extends RuntimeException{
    public ApplictionException() {
    }

    public ApplictionException(String message) {
        super(message);
    }

    public ApplictionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplictionException(Throwable cause) {
        super(cause);
    }
}
