package ru.javarush.cryptoanalyser.zamaraev.commands;

import ru.javarush.cryptoanalyser.zamaraev.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
