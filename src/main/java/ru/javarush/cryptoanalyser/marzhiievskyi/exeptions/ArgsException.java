package ru.javarush.cryptoanalyser.marzhiievskyi.exeptions;

public class ArgsException extends RuntimeException{
    public ArgsException() {
    }

    public ArgsException(String message) {
        super(message);
    }

    public ArgsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArgsException(Throwable cause) {
        super(cause);
    }
}
