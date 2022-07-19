package ru.javarush.cryptoanalyzer.kislyakova.controller;

import ru.javarush.cryptoanalyzer.kislyakova.commands.Action;
import ru.javarush.cryptoanalyzer.kislyakova.entity.Result;
import ru.javarush.cryptoanalyzer.kislyakova.entity.ResultCode;
import ru.javarush.cryptoanalyzer.kislyakova.exception.AppException;

public class MainController {
    public Result execute(String command, String[] parameters) {
        try {
            Action action = Actions.find(command);
            return action.execute(parameters);
        } catch (AppException e){
            //TODO log file for exceptions
            return new Result(ResultCode.ERROR, e.getMessage()); //берем сообщение из экцепшна
        }
    }
}
