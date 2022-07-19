package ru.javarush.cryptoanalyzer.uzienko.controllers;

import ru.javarush.cryptoanalyzer.uzienko.entity.Result;

public interface AppController {
    Result execute(String[] args);
}
