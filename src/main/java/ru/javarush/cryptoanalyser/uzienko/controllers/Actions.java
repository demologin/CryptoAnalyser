package ru.javarush.cryptoanalyser.uzienko.controllers;

import ru.javarush.cryptoanalyser.uzienko.commands.*;
import ru.javarush.cryptoanalyser.uzienko.exceptions.ApplicationException;

public enum Actions {
    ENCODE(new Encoder()),
    DECODE(new Decoder()),
    BRUTE_FORCE(new BruteForce()),
    STATISTICAL_DECRYPTION(new StatisticalDecoder()),
    ;

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String command) {
        try {
            return Actions.valueOf(command.toUpperCase()).action;
        } catch (IllegalArgumentException e) {
            throw new ApplicationException("No enum constant " + command, e);
        }
    }

}
