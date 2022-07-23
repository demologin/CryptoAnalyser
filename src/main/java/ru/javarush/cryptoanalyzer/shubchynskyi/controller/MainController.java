package ru.javarush.cryptoanalyzer.shubchynskyi.controller;

import ru.javarush.cryptoanalyzer.shubchynskyi.commands.Action;
import ru.javarush.cryptoanalyzer.shubchynskyi.entity.Result;
import ru.javarush.cryptoanalyzer.shubchynskyi.entity.ResultCode;
import ru.javarush.cryptoanalyzer.shubchynskyi.exception.ApplicationException;

public class MainController {

    public Result execute(String command, String[] parameters) {
        try {
            Action action = Actions.find(command);
            return action.execute(parameters);
        } catch (ApplicationException e) {
            return new Result(ResultCode.ERROR,e.getMessage());
        }
    }
}
