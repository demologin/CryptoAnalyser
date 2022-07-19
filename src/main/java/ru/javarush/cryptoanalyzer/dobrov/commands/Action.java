package ru.javarush.cryptoanalyzer.dobrov.commands;

import ru.javarush.cryptoanalyzer.dobrov.entity.Result;

public interface Action {
    Result execute(int key);
}
