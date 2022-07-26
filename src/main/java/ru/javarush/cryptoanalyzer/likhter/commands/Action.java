package ru.javarush.cryptoanalyzer.likhter.commands;

import ru.javarush.cryptoanalyzer.likhter.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}