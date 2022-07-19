package ru.javarush.cryptoanalyser.uzienko.views;

import ru.javarush.cryptoanalyser.uzienko.controllers.AppController;
import ru.javarush.cryptoanalyser.uzienko.entity.Result;

public interface View {
    Result execute(AppController appController, String[] args);
}
