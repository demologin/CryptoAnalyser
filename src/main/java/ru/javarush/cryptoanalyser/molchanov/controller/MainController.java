package ru.javarush.cryptoanalyser.molchanov.controller;

import ru.javarush.cryptoanalyser.molchanov.commands.Action;
import ru.javarush.cryptoanalyser.molchanov.entity.Result;

public class MainController {
    public Result execute(String command, String[] parameters) {
        Action actions = Actions.find(command);
        return actions.execute(parameters);
    }
}
