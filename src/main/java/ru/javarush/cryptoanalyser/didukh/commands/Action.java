package ru.javarush.cryptoanalyser.didukh.commands;

import ru.javarush.cryptoanalyser.didukh.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
