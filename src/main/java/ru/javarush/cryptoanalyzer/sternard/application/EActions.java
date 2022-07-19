package ru.javarush.cryptoanalyzer.sternard.application;

import ru.javarush.cryptoanalyzer.sternard.application.actions.BruteForceDecrypt;
import ru.javarush.cryptoanalyzer.sternard.application.actions.Decrypt;
import ru.javarush.cryptoanalyzer.sternard.application.actions.Encrypt;

public enum EActions {
    ENCRYPTION(new Encrypt()),
    KEY_DECRYPTION(new Decrypt()),
    BRUTE_FORCE_DECRYPTION(new BruteForceDecrypt());

    private final doAction action;

    EActions(doAction action) {
        this.action = action;
    }

    public doAction getAction(String command) {
        return EActions.valueOf(command.toUpperCase()).action;
    }

}