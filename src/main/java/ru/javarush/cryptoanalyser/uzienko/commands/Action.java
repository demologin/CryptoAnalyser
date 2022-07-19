package ru.javarush.cryptoanalyser.uzienko.commands;

import ru.javarush.cryptoanalyser.uzienko.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
