package ru.javarush.cryptoanalyzer.khmelov.controller;

import ru.javarush.cryptoanalyzer.khmelov.commands.Action;
import ru.javarush.cryptoanalyzer.khmelov.commands.Decoder;
import ru.javarush.cryptoanalyzer.khmelov.commands.Encoder;

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
