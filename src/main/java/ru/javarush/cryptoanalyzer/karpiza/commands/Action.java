package ru.javarush.cryptoanalyzer.karpiza.commands;

import ru.javarush.cryptoanalyzer.karpiza.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
