package ru.javarush.cryptoanalyser.moskvitina.commands;

import ru.javarush.cryptoanalyser.moskvitina.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
