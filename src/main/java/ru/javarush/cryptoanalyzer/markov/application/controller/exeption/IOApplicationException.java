package ru.javarush.cryptoanalyzer.markov.application.controller.exeption;

public class IOApplicationException extends RuntimeException{

    //TODO Code style. Many warnings. Skip or fix it.

    public IOApplicationException() {
        super();
    }

    public IOApplicationException(String message) {
        super(message);
    }

    public IOApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public IOApplicationException(Throwable cause) {
        super(cause);
    }
}
