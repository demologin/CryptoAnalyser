package ru.javarush.cryptoanalyzer.sapun.commands;

import ru.javarush.cryptoanalyzer.sapun.entity.Result;

public interface Action {
    int KEY = 4123456;
    Result execute (String[] parameters);
}
