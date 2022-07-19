package ru.javarush.cryptoanalyser.molchanov.controller;

import ru.javarush.cryptoanalyser.molchanov.commands.*;

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
