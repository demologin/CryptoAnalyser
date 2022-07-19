package ru.javarush.cryptoanalyser.marzhiievskyi.controller;

import ru.javarush.cryptoanalyser.marzhiievskyi.commands.*;
import ru.javarush.cryptoanalyser.marzhiievskyi.constants.Strings;
import ru.javarush.cryptoanalyser.marzhiievskyi.exeptions.ArgsException;

public enum ActionsContainer {
    ENCRYPT(new Encryption()),
    DECRYPT(new Decryption()),
    BRUTEFORCE(new BruteForce()),
    TEXTANALYZER(new TextAnalyzer());

    public final Action action;


    ActionsContainer(Action action) {
        this.action = action;
    }

    public static Action find(String command) {
        try {
            return ActionsContainer.valueOf(command.toUpperCase()).action;
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new ArgsException(Strings.ARGS_EXCEPTION_MSG);
        }
    }
}
