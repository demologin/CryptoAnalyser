package ru.javarush.cryptoanalyzer.marzhiievskyi.commands;

import ru.javarush.cryptoanalyzer.marzhiievskyi.entity.Result;

public interface Action {

    Result execute(String[] parameters);
}
