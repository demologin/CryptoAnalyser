package ru.javarush.cryptoanalyzer.kurchavov.controller;

import ru.javarush.cryptoanalyzer.kurchavov.commands.Action;
import ru.javarush.cryptoanalyzer.kurchavov.entity.Result;
import ru.javarush.cryptoanalyzer.kurchavov.entity.ResultCode;
import ru.javarush.cryptoanalyzer.kurchavov.exceptions.ApplicationException;

import java.io.IOException;

public class MainController{
    public Result execute(String command, String[] parameters) throws IOException, ApplicationException{
        Action action = Actions.getActionByName(command);
        if (action == null)
            return new Result(ResultCode.ERROR, "introduced unknown operation!");
        return action.execute(parameters);
    }
}
