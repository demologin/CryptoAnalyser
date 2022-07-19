package ru.javarush.cryptoanalyser.moskvitina.controller;

import ru.javarush.cryptoanalyser.moskvitina.commands.*;

public enum Actions {

    ENCODE(new Encoder()),
    DECODE(new Decoder()),
    BRUTEFORCE(new Bruteforce()),
    EXIT(new Exit());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String command) {
        return Actions.valueOf(command.toUpperCase()).action;

    }
}
