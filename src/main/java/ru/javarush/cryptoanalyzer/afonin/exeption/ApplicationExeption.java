package ru.javarush.cryptoanalyzer.afonin.exeption;

public class ApplicationExeption extends RuntimeException {
    //TODO Code style. Many warnings. Skip or fix it.
    public ApplicationExeption() {
        super();
    }

    public ApplicationExeption(String message) {
        super(message);
    }

    public ApplicationExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationExeption(Throwable cause) {
        super(cause);
    }
}
