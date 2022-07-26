package ru.javarush.cryptoanalyzer.gamora.entity;

import ru.javarush.cryptoanalyzer.gamora.actions.Actions;

public final class Result {
    public final ResultCode resultCode;
    public Actions actions;

    public Result(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public void setAction(Actions valueOf) {
        this.actions = valueOf;
    }
}
