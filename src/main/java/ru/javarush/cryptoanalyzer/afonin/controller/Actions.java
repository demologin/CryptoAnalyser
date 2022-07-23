package ru.javarush.cryptoanalyzer.afonin.controller;

import ru.javarush.cryptoanalyzer.afonin.commands.*;

public enum Actions {

    BRUTEFORCE_DECODE(new BruteForceDecoder()),
    DECODE(new Decoder()),
    ENCODE(new Encoder()),
    EXIT(new Exit()),
    STATISTICAL_DECRYPT(new StatisticalDecrypt());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String command) {
        return Actions.valueOf(command.toUpperCase().replace('-', '_')).action;
    }
}
