package ru.javarush.cryptoanalyser.uzienko.toplevel;

import ru.javarush.cryptoanalyser.uzienko.controllers.AppController;
import ru.javarush.cryptoanalyser.uzienko.entity.Result;
import ru.javarush.cryptoanalyser.uzienko.views.View;

public class Application {
    private final AppController appController;
    private final View view;

    public Application(AppController appController, View view) {
        this.appController = appController;
        this.view = view;
    }

    public Result run(String[] args) {
        return view.execute(appController, args);
    }
}
