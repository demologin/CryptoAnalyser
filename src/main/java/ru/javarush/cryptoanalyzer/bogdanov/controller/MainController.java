package ru.javarush.cryptoanalyzer.bogdanov.controller;

import ru.javarush.cryptoanalyzer.bogdanov.comands.Action;
import ru.javarush.cryptoanalyzer.bogdanov.entity.Result;

public class MainController {
    public Result execute(String operation, String[] parametrs) {
        Action action = Actions.find(operation);
        return action.execute(parametrs);

    }
}
