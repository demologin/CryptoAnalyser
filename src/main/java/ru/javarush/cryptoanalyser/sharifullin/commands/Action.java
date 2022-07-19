package ru.javarush.cryptoanalyser.sharifullin.commands;

import ru.javarush.cryptoanalyser.sharifullin.entity.Result;

public interface Action {
    Result execute (String[] parameters);

}
