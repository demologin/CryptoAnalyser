package ru.javarush.cryptoanalyser.dobrov.controller;

import ru.javarush.cryptoanalyser.dobrov.commands.Action;
import ru.javarush.cryptoanalyser.dobrov.commands.BruteForce;
import ru.javarush.cryptoanalyser.dobrov.commands.Decoder;
import ru.javarush.cryptoanalyser.dobrov.commands.Encoder;

@SuppressWarnings("ALL")
public enum Actions {
    ENCODE(new Encoder()),
    DECODE(new Decoder()),
    BRUTEFORCE(new BruteForce());
    private final Action action;


    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String command) {
        return Actions.valueOf(command.toUpperCase()).action;
    }
}
