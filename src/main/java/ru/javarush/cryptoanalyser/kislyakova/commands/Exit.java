package ru.javarush.cryptoanalyser.kislyakova.commands;

import ru.javarush.cryptoanalyser.kislyakova.entity.Result;
import ru.javarush.cryptoanalyser.kislyakova.entity.ResultCode;

public class Exit implements Action{
    @Override
    public Result execute(String[] parameters) {
        System.exit(0);
        return new Result(ResultCode.OK, "Завершение работы программы");
    }
}
