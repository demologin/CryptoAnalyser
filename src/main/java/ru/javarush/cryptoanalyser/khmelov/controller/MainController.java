package ru.javarush.cryptoanalyser.khmelov.controller;

import ru.javarush.cryptoanalyser.khmelov.commands.Action;
import ru.javarush.cryptoanalyser.khmelov.entity.Result;
import ru.javarush.cryptoanalyser.khmelov.entity.ResultCode;
import ru.javarush.cryptoanalyser.khmelov.exception.ApplicationException;

public class MainController {
    public Result execute(String command, String[] parameters) {
        try {
            Action action=Actions.find(command);
            return action.execute(parameters);
        } catch (ApplicationException e){
            //TODO log file for exceptions
            return new Result(ResultCode.ERROR,e.getMessage());
        }

    }
}
