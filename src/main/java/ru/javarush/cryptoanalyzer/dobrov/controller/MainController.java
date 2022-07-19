package ru.javarush.cryptoanalyzer.dobrov.controller;

import ru.javarush.cryptoanalyzer.dobrov.commands.Action;
import ru.javarush.cryptoanalyzer.dobrov.entity.Result;
import ru.javarush.cryptoanalyzer.dobrov.entity.ResultCode;
import ru.javarush.cryptoanalyzer.dobrov.exception.ApplicationException;

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
