package ru.javarush.cryptoanalyzer.cherepovskiy.controller;

import ru.javarush.cryptoanalyzer.cherepovskiy.commands.Action;
import ru.javarush.cryptoanalyzer.cherepovskiy.entity.Result;
import ru.javarush.cryptoanalyzer.cherepovskiy.entity.ResultCode;
import ru.javarush.cryptoanalyzer.cherepovskiy.exceptions.AppException;

public class Controller {
    public Result execute(String command, String[] parametrs) {
        try {
            Action action = Actions.find(command);
            return action.execute(parametrs);
        } catch (AppException e) {
            return new Result(ResultCode.ERROR, e.getMessage());
        }
    }
}
