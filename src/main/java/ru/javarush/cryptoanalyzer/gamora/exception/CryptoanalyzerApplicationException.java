package ru.javarush.cryptoanalyzer.gamora.exception;

public class CryptoanalyzerApplicationException extends RuntimeException {
    public CryptoanalyzerApplicationException() {
        super();
    }

    public CryptoanalyzerApplicationException(String message) {
        super(message);
    }

    public CryptoanalyzerApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public CryptoanalyzerApplicationException(Throwable cause) {
        super(cause);
    }

    protected CryptoanalyzerApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
