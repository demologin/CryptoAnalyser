package ru.javarush.cryptoanalyzer.gamora.exception;

public enum ExceptionMessages {
    BRUTE_FAILED("Wasn't able to decode text with brute force"),
    INVALID_COMMAND("Wasn't able to find the given command. Please use help command to explore documentation."),
    INVALID_ARGUMENTS("Cannot use given command with given arguments. Please use help command to explore documentation.");

    public final String exceptionMessage;

    ExceptionMessages(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
}
