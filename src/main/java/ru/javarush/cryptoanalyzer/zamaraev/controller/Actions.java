package ru.javarush.cryptoanalyzer.zamaraev.controller;

import ru.javarush.cryptoanalyzer.zamaraev.commands.*;

public enum Actions {
    ENCODE(new Encoder()),
    DECODE(new Decoder()),
    BRUTEFORCE(new BruteForce()),
    STATICANALYSIS(new StaticAnalysis());

    private  final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String command) {
        return Actions.valueOf(command.toUpperCase()).action;
    }
}
