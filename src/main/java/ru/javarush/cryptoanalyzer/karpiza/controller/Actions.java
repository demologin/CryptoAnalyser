package ru.javarush.cryptoanalyzer.karpiza.controller;

import ru.javarush.cryptoanalyzer.karpiza.commands.Action;
import ru.javarush.cryptoanalyzer.karpiza.commands.Decoder;
import ru.javarush.cryptoanalyzer.karpiza.commands.Encoder;

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
