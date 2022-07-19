package ru.javarush.cryptoanalyser.dobrov.controller;

import ru.javarush.cryptoanalyser.dobrov.commands.Action;
import ru.javarush.cryptoanalyser.dobrov.entity.Result;
import ru.javarush.cryptoanalyser.dobrov.entity.ResultCode;
import ru.javarush.cryptoanalyser.dobrov.exception.ApplicationException;

public class MainController {
    public Result execute(String command,int key) {
        try {
            Action action = Actions.find(command);
            return action.execute(key);
        } catch (ApplicationException e) {
            return new Result(ResultCode.ERROR, e.getMessage());
        }
    }
}
