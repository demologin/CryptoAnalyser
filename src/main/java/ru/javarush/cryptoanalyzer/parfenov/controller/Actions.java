package ru.javarush.cryptoanalyzer.parfenov.controller;

import ru.javarush.cryptoanalyzer.parfenov.commands.*;

public enum Actions {
    ENCRYPT(new Encrypt()),
    DECRYPT(new Decrypt()),
    BRUTE(new Brute()),
    STATISTICS(new Statistics());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String command) {
        return Actions.valueOf(command.toUpperCase()).action;
    }
}
