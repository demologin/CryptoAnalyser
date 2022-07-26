package ru.javarush.cryptoanalyzer.sapun.controller;

import ru.javarush.cryptoanalyzer.sapun.commands.*;

public enum Actions {
    ENCODE(new Encoder()),
    DECODE(new Decoder()),
    BRUTEFORCE(new BrutForce()),
    STATISTIC(new StatisticAnalysis())
    ;

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String command) {
        return Actions.valueOf(command.toUpperCase()).action;
    }
}
