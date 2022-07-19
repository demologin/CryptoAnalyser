package ru.javarush.cryptoanalyzer.uzienko.commands;

import ru.javarush.cryptoanalyzer.uzienko.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
