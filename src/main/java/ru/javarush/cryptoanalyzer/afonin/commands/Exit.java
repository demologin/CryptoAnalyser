package ru.javarush.cryptoanalyzer.afonin.commands;

import ru.javarush.cryptoanalyzer.afonin.entity.Result;
import ru.javarush.cryptoanalyzer.afonin.entity.ResultCode;

public class Exit extends Action {
    @Override
    public Result execute(String[] parameters) {
        return new Result(ResultCode.OK, "Спасибо что зашли!");
    }
}
