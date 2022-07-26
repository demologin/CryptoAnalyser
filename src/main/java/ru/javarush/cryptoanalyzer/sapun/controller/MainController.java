package ru.javarush.cryptoanalyzer.sapun.controller;

import ru.javarush.cryptoanalyzer.sapun.commands.Action;
import ru.javarush.cryptoanalyzer.sapun.entity.Result;

public class MainController {
    public Result execute(String command, String[] parameters) {
        Action action = Actions.find(command);
        return action.execute(parameters);

    }
}
