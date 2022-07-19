package ru.javarush.cryptoanalyzer.didukh.controller;

import ru.javarush.cryptoanalyzer.didukh.commands.*;

public enum Actions {
    ENCODE(new Encoder()),
    DECODE(new Decoder()),
    BRUTE(new Brute()),
    STATISTIC(new Statistic());
    private final Action action;


    Actions(Action action) {

        this.action = action;
    }

    public static Action find(String command) {

        return Actions.valueOf(command.toUpperCase()).action;
    }
}
