package ru.javarush.cryptoanalyser.karpiza.controller;

import ru.javarush.cryptoanalyser.karpiza.commands.Action;
import ru.javarush.cryptoanalyser.karpiza.entity.Result;
import ru.javarush.cryptoanalyser.karpiza.entity.ResultCode;
import ru.javarush.cryptoanalyser.karpiza.exception.ApplicationException;

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
