package ru.javarush.cryptoanalyzer.khmelov.controller;

import ru.javarush.cryptoanalyzer.khmelov.command.Action;
import ru.javarush.cryptoanalyzer.khmelov.entity.Result;
import ru.javarush.cryptoanalyzer.khmelov.entity.ResultCode;
import ru.javarush.cryptoanalyzer.khmelov.exception.AppException;

public class MainController {

    public Result doAction(String actionName, String[] parameters) {
        Action action = ActionContainer.get(actionName);
        try {
            return action.execute(parameters);
        } catch (NumberFormatException | AppException e) {
            return new Result(ResultCode.ERROR, e.getMessage());
        }
    }
}
