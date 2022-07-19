package ru.javarush.cryptoanalyzer.marzhiievskyi.controller;

import ru.javarush.cryptoanalyzer.marzhiievskyi.commands.Action;
import ru.javarush.cryptoanalyzer.marzhiievskyi.entity.Result;
import ru.javarush.cryptoanalyzer.marzhiievskyi.entity.ResultCode;
import ru.javarush.cryptoanalyzer.marzhiievskyi.exeptions.AppException;
import ru.javarush.cryptoanalyzer.marzhiievskyi.exeptions.ArgsException;
import ru.javarush.cryptoanalyzer.marzhiievskyi.exeptions.KeyShiftException;

public class MainController {
    public Result execute(String command, String[] parameters) {
        try {
            Action action = ActionsContainer.find(command);
            return action.execute(parameters);
        } catch (AppException | ArgsException | KeyShiftException exception) {
            return new Result(ResultCode.ERROR, "Неудача. " + exception.getMessage());
        }
    }

}
