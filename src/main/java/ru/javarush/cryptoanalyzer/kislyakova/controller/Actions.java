package ru.javarush.cryptoanalyzer.kislyakova.controller;
import ru.javarush.cryptoanalyzer.kislyakova.commands.*;

public enum Actions {
    CIPHER(new Cipher()),
    DECIPHER(new Decipher()),
    BRUTEFORCE(new Bruteforce()),
    EXIT(new Exit());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String command) {
       return Actions.valueOf(command.toUpperCase()).action;
    }
}
