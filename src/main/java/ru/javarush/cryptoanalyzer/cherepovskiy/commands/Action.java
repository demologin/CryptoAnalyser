package ru.javarush.cryptoanalyzer.cherepovskiy.commands;

import ru.javarush.cryptoanalyzer.cherepovskiy.entity.Result;

import java.util.HashMap;

public interface Action {

    Result execute(String[] parametrs);
}
