package ru.javarush.cryptoanalyzer.gamora.actions;

import ru.javarush.cryptoanalyzer.gamora.entity.Result;
import ru.javarush.cryptoanalyzer.gamora.entity.ResultCode;

public class Start implements Action {
    @Override
    public Result execute() {
        return new Result(ResultCode.OK);
    }

    @Override
    public void build(String[] args) {}
}
