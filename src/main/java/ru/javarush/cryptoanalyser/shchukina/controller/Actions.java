package ru.javarush.cryptoanalyser.shchukina.controller;

import ru.javarush.cryptoanalyser.shchukina.command.*;

public enum Actions {

    ENCRYPT(new Encrypter()),
    DECRYPT(new Decrypter()),
    DECRYPT_BY_BRUTE_FORCE(new BruteForcer()),
    DECRYPT_BY_STATISTICAL_ANALYZE(new StatisticalAnalyzer());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String command) {
        return Actions.valueOf(command.toUpperCase()).action;
    }
}
