package ru.javarush.cryptoanalyzer.uzienko.views;

import ru.javarush.cryptoanalyzer.uzienko.controllers.AppController;
import ru.javarush.cryptoanalyzer.uzienko.entity.Result;

public interface View {
    Result execute(AppController appController, String[] args);
}
