package ru.javarush.cryptoanalyser.marzhiievskyi.commands;

import ru.javarush.cryptoanalyser.marzhiievskyi.entity.Result;

public interface Action {

    Result execute(String[] parameters);
}
