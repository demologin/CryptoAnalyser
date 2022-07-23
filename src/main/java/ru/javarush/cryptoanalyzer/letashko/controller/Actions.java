package ru.javarush.cryptoanalyzer.letashko.controller;

import ru.javarush.cryptoanalyzer.letashko.commands.Action;
import ru.javarush.cryptoanalyzer.letashko.commands.Decoder;
import ru.javarush.cryptoanalyzer.letashko.commands.Encoder;

public enum Actions {

    ENCODE(new Encoder()),
    DECODE(new Decoder());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String command) {
        return Actions.valueOf(command.toUpperCase()).action;

    }
}
