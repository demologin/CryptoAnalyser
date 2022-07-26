package ru.javarush.cryptoanalyzer.gamora.actions;

import ru.javarush.cryptoanalyzer.gamora.actions.basicactions.Decoder;
import ru.javarush.cryptoanalyzer.gamora.actions.basicactions.Encoder;
import ru.javarush.cryptoanalyzer.gamora.actions.cryptoactions.Decrypt;
import ru.javarush.cryptoanalyzer.gamora.actions.cryptoactions.Encrypt;

import java.util.Locale;

public enum Actions {
    //TODO Code style. Many warnings. Skip or fix it.
    START(new Start()),
    HELP(new Help()),
    EXIT(new Exit()),
    ENCODE(new Encoder()),
    ENCRYPT(new Encrypt()),
    DECRYPT(new Decrypt()),
    DECODE(new Decoder());

    public final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String command) {
        return Actions.valueOf(command.toUpperCase(Locale.ROOT)).action;
    }
}
