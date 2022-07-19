package ru.javarush.cryptoanalyser.sharifullin.controller;

import ru.javarush.cryptoanalyser.sharifullin.commands.Action;
import ru.javarush.cryptoanalyser.sharifullin.entity.Result;
import ru.javarush.cryptoanalyser.sharifullin.entity.ResultCode;
import ru.javarush.cryptoanalyser.sharifullin.exception.ApplicationException;

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