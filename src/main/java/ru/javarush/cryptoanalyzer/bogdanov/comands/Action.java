package ru.javarush.cryptoanalyzer.bogdanov.comands;

import ru.javarush.cryptoanalyzer.bogdanov.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
