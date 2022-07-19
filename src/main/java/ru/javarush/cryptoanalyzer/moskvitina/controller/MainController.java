package ru.javarush.cryptoanalyzer.moskvitina.controller;

import ru.javarush.cryptoanalyzer.moskvitina.commands.Action;
import ru.javarush.cryptoanalyzer.moskvitina.entity.Result;
import ru.javarush.cryptoanalyzer.moskvitina.entity.ResultCode;
import ru.javarush.cryptoanalyzer.moskvitina.exceptions.ApplicationException;

public class MainController {
    public Result execute(String command, String[] parameters) {
        try {
            Action action = Actions.find(command);
            return action.execute(parameters);
        } catch (ApplicationException e) {
            //TODO логировать исключения
            return  new Result(ResultCode.ERROR, e.getMessage());
        }

    }
}
