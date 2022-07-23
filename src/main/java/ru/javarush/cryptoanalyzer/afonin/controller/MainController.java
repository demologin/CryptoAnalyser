package ru.javarush.cryptoanalyzer.afonin.controller;

import ru.javarush.cryptoanalyzer.afonin.commands.Action;
import ru.javarush.cryptoanalyzer.afonin.entity.Result;
import ru.javarush.cryptoanalyzer.afonin.entity.ResultCode;
import ru.javarush.cryptoanalyzer.afonin.exeption.ApplicationExeption;

public class MainController {

    public Result execute(String command, String[] parameters) {
        Action action = Actions.find(command);
        try {
            return action.execute(parameters);
        } catch (NumberFormatException | ApplicationExeption e){
            //TODO Code style. Use Russian comments? Bad English is much better than the best Russian comments.
            return new Result(ResultCode.ERROR, "Такая вот фигня, брат:\n" + e);
        }
    }

}
