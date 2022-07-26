package ru.javarush.cryptoanalyzer.likhter.controller;
import ru.javarush.cryptoanalyzer.likhter.commands.Action;
import ru.javarush.cryptoanalyzer.likhter.entity.Result;

public class MainController {
    public Result execute(String command, String[] parameters) {
        Action action  = Actions.find(command);
        return action.execute(parameters);
    }
}