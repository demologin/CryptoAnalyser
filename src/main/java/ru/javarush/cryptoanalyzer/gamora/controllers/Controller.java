package ru.javarush.cryptoanalyzer.gamora.controllers;

import ru.javarush.cryptoanalyzer.gamora.entity.Result;

public interface Controller {
    Result execute(String command, String[] parameters);
}
