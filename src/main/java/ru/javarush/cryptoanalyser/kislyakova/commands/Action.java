package ru.javarush.cryptoanalyser.kislyakova.commands;
import ru.javarush.cryptoanalyser.kislyakova.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
