package ru.javarush.cryptoanalyser.dobrov.commands;

import ru.javarush.cryptoanalyser.dobrov.entity.Result;

public interface Action {
    Result execute(int key);
}
