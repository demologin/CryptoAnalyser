package ru.javarush.cryptoanalyzer.parfenov.commands;

import ru.javarush.cryptoanalyzer.parfenov.arguments.ArgumentTypes;
import ru.javarush.cryptoanalyzer.parfenov.entity.Result;

import java.util.Map;

public interface Action {
    Result execute(Map<ArgumentTypes, Object> arguments);
}
