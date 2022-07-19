package ru.javarush.cryptoanalyser.moskvitina.controller;

import ru.javarush.cryptoanalyser.moskvitina.commands.Action;
import ru.javarush.cryptoanalyser.moskvitina.entity.Result;
import ru.javarush.cryptoanalyser.moskvitina.entity.ResultCode;
import ru.javarush.cryptoanalyser.moskvitina.exceptions.ApplicationException;

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
