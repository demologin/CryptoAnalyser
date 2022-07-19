package ru.javarush.cryptoanalyzer.dobrov.controller;

import ru.javarush.cryptoanalyzer.dobrov.commands.Action;
import ru.javarush.cryptoanalyzer.dobrov.commands.BruteForce;
import ru.javarush.cryptoanalyzer.dobrov.commands.Decoder;
import ru.javarush.cryptoanalyzer.dobrov.commands.Encoder;

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
