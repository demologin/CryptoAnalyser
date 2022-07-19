package ru.javarush.cryptoanalyzer.karpiza.controller;

import ru.javarush.cryptoanalyzer.karpiza.commands.Action;
import ru.javarush.cryptoanalyzer.karpiza.entity.Result;
import ru.javarush.cryptoanalyzer.karpiza.entity.ResultCode;
import ru.javarush.cryptoanalyzer.karpiza.exception.ApplicationException;

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
