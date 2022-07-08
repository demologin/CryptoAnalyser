package ru.javarush.cryptoanalyser.khmelov.controller;

import ru.javarush.cryptoanalyser.khmelov.commands.Action;
import ru.javarush.cryptoanalyser.khmelov.entity.Result;

public class MainController {
    public Result execute(String command, String[] parameters) {
        Action action=Actions.find(command);
        return action.execute(parameters);
    }
}
