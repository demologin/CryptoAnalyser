package ru.javarush.cryptoanalyzer.letashko.controller;

import ru.javarush.cryptoanalyzer.letashko.commands.Action;
import ru.javarush.cryptoanalyzer.letashko.entity.Result;
import ru.javarush.cryptoanalyzer.letashko.entity.ResultCode;
import ru.javarush.cryptoanalyzer.letashko.exception.ApplicationException;

public class MainController {
    public Result execute(String command, String[] parameters) {
        try {
            Action action=Actions.find(command);
            return action.execute(parameters);
        } catch (ApplicationException e){
            return new Result(ResultCode.ERROR,e.getMessage());
        }

    }
}
