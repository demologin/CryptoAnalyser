package ru.javarush.cryptoanalyzer.gamora.actions;

import ru.javarush.cryptoanalyzer.gamora.entity.Result;

public interface Action {

    Result execute();

    void build (String[] args);

}
