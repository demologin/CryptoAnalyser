package ru.javarush.cryptoanalyzer.sharifullin.controller;

import ru.javarush.cryptoanalyzer.sharifullin.commands.Action;
import ru.javarush.cryptoanalyzer.sharifullin.entity.Result;
import ru.javarush.cryptoanalyzer.sharifullin.entity.ResultCode;
import ru.javarush.cryptoanalyzer.sharifullin.exception.ApplicationException;

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