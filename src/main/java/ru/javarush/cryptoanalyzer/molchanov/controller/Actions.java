package ru.javarush.cryptoanalyzer.molchanov.controller;

import ru.javarush.cryptoanalyzer.molchanov.commands.*;

public enum Actions {
    ENCODE(new Encoder()),
    DECODE(new Decoder()),
    BRUTEFORCE(new BruteForce()),
    STATISTICANALISE(new StatisticAnalise());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String command) {
        return Actions.valueOf(command.toUpperCase()).action;
    }
}
