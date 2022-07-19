package ru.javarush.cryptoanalyzer.zamaraev.controller;

import ru.javarush.cryptoanalyzer.zamaraev.commands.Action;
import ru.javarush.cryptoanalyzer.zamaraev.entity.Result;
import ru.javarush.cryptoanalyzer.zamaraev.entity.ResultCode;
import ru.javarush.cryptoanalyzer.zamaraev.exception.ApplictionException;

public class MainController {
    public Result execute (String command, String[] parameters){
        try {
            Action action = Actions.find(command);
            return action.execute(parameters);
        } catch (ApplictionException e) {
            return new Result(ResultCode.ERROR,e.getMessage());
        }
    }
}
