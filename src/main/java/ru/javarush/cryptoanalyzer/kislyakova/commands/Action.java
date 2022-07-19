package ru.javarush.cryptoanalyzer.kislyakova.commands;
import ru.javarush.cryptoanalyzer.kislyakova.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
