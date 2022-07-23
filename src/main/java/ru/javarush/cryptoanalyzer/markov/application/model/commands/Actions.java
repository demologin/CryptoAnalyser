package ru.javarush.cryptoanalyzer.markov.application.model.commands;

public enum Actions {
    ENCODER(new Encoder()),
    DECODER(new Decoder()),
    BRUTE_FORCE(new BruteForce());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String command) {
        return Actions.valueOf(command.toUpperCase()).action;
    }

}
