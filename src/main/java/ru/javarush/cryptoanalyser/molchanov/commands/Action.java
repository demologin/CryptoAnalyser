package ru.javarush.cryptoanalyser.molchanov.commands;

import ru.javarush.cryptoanalyser.molchanov.entity.Result;

public interface Action {
    Result execute (String[] parameters);
}
