package ru.javarush.cryptoanalyzer.khmelov.commands;

import ru.javarush.cryptoanalyzer.khmelov.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
