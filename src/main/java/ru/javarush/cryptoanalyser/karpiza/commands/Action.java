package ru.javarush.cryptoanalyser.karpiza.commands;

import ru.javarush.cryptoanalyser.karpiza.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
