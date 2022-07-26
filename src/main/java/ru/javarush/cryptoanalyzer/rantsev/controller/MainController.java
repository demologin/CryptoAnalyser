package ru.javarush.cryptoanalyzer.rantsev.controller;

import ru.javarush.cryptoanalyzer.rantsev.commands.Action;
import ru.javarush.cryptoanalyzer.rantsev.entity.Result;
import ru.javarush.cryptoanalyzer.rantsev.entity.ResultCode;
import ru.javarush.cryptoanalyzer.rantsev.exception.ConsoleAppException;

public class MainController {
    public void execute(String command, String[] parameters) {
        try {
            Action action = Actions.find(command);
            action.execute(parameters);
        } catch (ConsoleAppException e) {
            new Result(ResultCode.ERROR, e.getMessage());
        }
    }
}
