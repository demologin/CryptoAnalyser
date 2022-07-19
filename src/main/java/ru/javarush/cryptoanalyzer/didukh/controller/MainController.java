package ru.javarush.cryptoanalyzer.didukh.controller;

import ru.javarush.cryptoanalyzer.didukh.commands.Action;
import ru.javarush.cryptoanalyzer.didukh.entity.Result;

public class MainController {
    public Result execute(String command, String[] parameters) {
        Action action = Actions.find(command);
        return action.execute(parameters);
    }
}
