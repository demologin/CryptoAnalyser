package ru.javarush.cryptoanalyzer.khmelov.command;

import ru.javarush.cryptoanalyzer.khmelov.entity.Result;

public interface Action {

    Result execute(String[] parameters);


}
