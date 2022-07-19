package ru.javarush.cryptoanalyser.shchukina.command;

import ru.javarush.cryptoanalyser.shchukina.entity.Result;

public interface Action {

    Result execute(String[] parameters);

}
