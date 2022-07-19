package ru.javarush.cryptoanalyzer.molchanov.controller;

import ru.javarush.cryptoanalyzer.molchanov.commands.Action;
import ru.javarush.cryptoanalyzer.molchanov.entity.Result;

public class MainController {
    public Result execute(String command, String[] parameters) {
        Action actions = Actions.find(command);
        return actions.execute(parameters);
    }
}
