package ru.javarush.cryptoanalyser.didukh.controller;

import ru.javarush.cryptoanalyser.didukh.commands.Action;
import ru.javarush.cryptoanalyser.didukh.entity.Result;

public class MainController {
    public Result execute(String command, String[] parameters) {
        Action action = Actions.find(command);
        return action.execute(parameters);
    }
}
