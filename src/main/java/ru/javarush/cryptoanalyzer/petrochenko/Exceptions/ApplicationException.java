//TODO ---  package contains Uppercase symbols
package ru.javarush.cryptoanalyzer.petrochenko.Exceptions;

public class ApplicationException extends  RuntimeException{

    public ApplicationException() {
        super();
    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }
}
