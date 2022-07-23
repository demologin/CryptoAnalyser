package ru.javarush.cryptoanalyzer.parfenov.controller;

import ru.javarush.cryptoanalyzer.parfenov.arguments.ArgumentTypes;
import ru.javarush.cryptoanalyzer.parfenov.commands.Action;
import ru.javarush.cryptoanalyzer.parfenov.entity.Result;
import ru.javarush.cryptoanalyzer.parfenov.exception.ApplicationException;

import java.util.Map;

public class MainController {


    public Result execute(Map<ArgumentTypes, Object> arguments) {
        Action action;
        try {
            action = (Action) arguments.get(ArgumentTypes.COMMAND);
        } catch (ClassCastException e) {
            throw new ApplicationException("Somehow command is not in action...");
        }
        return action.execute(arguments);
    }
}
