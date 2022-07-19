package ru.javarush.cryptoanalyser.sharifullin.controller;

import ru.javarush.cryptoanalyser.sharifullin.commands.*;

public enum Actions {

    ENCODE(new Encoder()),
    DECODE(new Decoder()),
    BRUT(new BrutForce()),
    ANALYS(new StaticAnalysis());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String command) {
        return Actions.valueOf(command.toUpperCase()).action;

    }
}
