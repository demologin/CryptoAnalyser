package ru.javarush.cryptoanalyser.khmelov.commands;

import ru.javarush.cryptoanalyser.khmelov.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
