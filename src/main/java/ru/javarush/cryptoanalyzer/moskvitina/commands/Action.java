package ru.javarush.cryptoanalyzer.moskvitina.commands;

import ru.javarush.cryptoanalyzer.moskvitina.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
