package ru.javarush.cryptoanalyzer.molchanov.commands;

import ru.javarush.cryptoanalyzer.molchanov.entity.Result;

public interface Action {
    Result execute (String[] parameters);
}
