package ru.javarush.cryptoanalyzer.cherepovskiy.commands;

import ru.javarush.cryptoanalyzer.cherepovskiy.entity.Result;
import ru.javarush.cryptoanalyzer.cherepovskiy.entity.ResultCode;

public class Exit implements Action {

    @Override
    public Result execute(String[] parametrs) {
        System.exit(0);
        return new Result(ResultCode.OK, "EXIT");
    }
}
