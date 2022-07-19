package ru.javarush.cryptoanalyzer.zamaraev.commands;

import ru.javarush.cryptoanalyzer.zamaraev.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
