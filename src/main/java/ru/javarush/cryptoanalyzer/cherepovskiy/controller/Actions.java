package ru.javarush.cryptoanalyzer.cherepovskiy.controller;

import ru.javarush.cryptoanalyzer.cherepovskiy.commands.*;

public enum Actions {
    ENCRYPT(new Encrypt()),
    DECRYPT(new Decrypt()),
    BRUTEFORCE(new BruteForce()),
    ANALYSE(new Analyze()),
    EXIT(new Exit());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String command) {
        return Actions.valueOf(command.toUpperCase()).action;
    }
}
