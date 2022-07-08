package ru.javarush.cryptoanalyser.khmelov.controller;

import ru.javarush.cryptoanalyser.khmelov.commands.Action;
import ru.javarush.cryptoanalyser.khmelov.commands.Decoder;
import ru.javarush.cryptoanalyser.khmelov.commands.Encoder;

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
