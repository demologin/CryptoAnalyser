package ru.javarush.cryptoanalyser.marzhiievskyi.controller;

import ru.javarush.cryptoanalyser.marzhiievskyi.commands.Action;
import ru.javarush.cryptoanalyser.marzhiievskyi.entity.Result;
import ru.javarush.cryptoanalyser.marzhiievskyi.entity.ResultCode;
import ru.javarush.cryptoanalyser.marzhiievskyi.exeptions.AppException;
import ru.javarush.cryptoanalyser.marzhiievskyi.exeptions.ArgsException;
import ru.javarush.cryptoanalyser.marzhiievskyi.exeptions.KeyShiftException;

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
