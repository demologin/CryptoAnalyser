package ru.javarush.cryptoanalyser.zamaraev.controller;

import ru.javarush.cryptoanalyser.zamaraev.commands.Action;
import ru.javarush.cryptoanalyser.zamaraev.entity.Result;
import ru.javarush.cryptoanalyser.zamaraev.entity.ResultCode;
import ru.javarush.cryptoanalyser.zamaraev.exception.ApplictionException;

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
