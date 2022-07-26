package ru.javarush.cryptoanalyzer.gamora.actions;

import ru.javarush.cryptoanalyzer.gamora.exception.CryptoanalyzerApplicationException;
import ru.javarush.cryptoanalyzer.gamora.exception.ExceptionMessages;

public class ActionFactory {

    public ActionFactory() {
    }

    public Action getAction(String [] args) {
        //TODO Code style. Use Russian comments? Bad English is much better than the best Russian comments.
        //TODO: логика выбора действия
        String command = args[0];
        Action action = parseAction(command);
        try {
            action.build(args);
        } catch (IndexOutOfBoundsException e) {
            throw new CryptoanalyzerApplicationException(ExceptionMessages.INVALID_ARGUMENTS.exceptionMessage);
        }
        return action;
    }

    private Action parseAction(String command) {
        String enumCommand = command.toUpperCase();
        return Actions.valueOf(enumCommand).action;
    }
}
