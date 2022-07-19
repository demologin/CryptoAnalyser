package ru.javarush.cryptoanalyzer.sharifullin.commands;

import ru.javarush.cryptoanalyzer.sharifullin.entity.Result;

public interface Action {
    Result execute (String[] parameters);

}
