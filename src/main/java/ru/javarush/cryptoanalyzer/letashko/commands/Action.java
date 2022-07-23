package ru.javarush.cryptoanalyzer.letashko.commands;

import ru.javarush.cryptoanalyzer.letashko.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
