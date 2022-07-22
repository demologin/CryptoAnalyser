package ru.javarush.cryptoanalyzer.khmelov.controller;

import ru.javarush.cryptoanalyzer.khmelov.command.*;
import ru.javarush.cryptoanalyzer.khmelov.constant.Const;
import ru.javarush.cryptoanalyzer.khmelov.exception.AppException;

@SuppressWarnings("unused")
public enum ActionContainer {

    ENCODE(new Encode()),
    DECODE(new Decode()),
    BRUTEFORCE(new BruteForce()),
    ANALYZE(new Analyze()),
    EXIT(new Exit());

    private final Action action;

    ActionContainer(Action action) {
        this.action = action;
    }

    public static Action get(String actionName) {
        try {
            ActionContainer value = ActionContainer.valueOf(actionName.toUpperCase());
            return value.action;
        } catch (IllegalArgumentException e) {
            String message = String.format(Const.NOT_FOUND_ACTION_FORMAT, actionName);
            throw new AppException(message, e);
        }
    }
}
