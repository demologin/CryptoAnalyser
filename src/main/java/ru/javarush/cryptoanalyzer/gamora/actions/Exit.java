package ru.javarush.cryptoanalyzer.gamora.actions;

import ru.javarush.cryptoanalyzer.gamora.entity.Result;
import ru.javarush.cryptoanalyzer.gamora.entity.ResultCode;

public class Exit implements Action {
    @Override
    public Result execute() {
        return new Result(ResultCode.DONE);
    }

    @Override
    public void build(String[] args) {

    }
}
