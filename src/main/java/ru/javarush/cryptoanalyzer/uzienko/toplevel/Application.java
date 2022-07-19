package ru.javarush.cryptoanalyzer.uzienko.toplevel;

import ru.javarush.cryptoanalyzer.uzienko.controllers.AppController;
import ru.javarush.cryptoanalyzer.uzienko.entity.Result;
import ru.javarush.cryptoanalyzer.uzienko.views.View;

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
