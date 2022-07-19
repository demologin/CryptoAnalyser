package ru.javarush.cryptoanalyzer.didukh.commands;

import ru.javarush.cryptoanalyzer.didukh.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
