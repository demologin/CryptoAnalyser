package ru.javarush.cryptoanalyzer.uzienko;

import ru.javarush.cryptoanalyzer.uzienko.controllers.AppController;
import ru.javarush.cryptoanalyzer.uzienko.controllers.MainController;
import ru.javarush.cryptoanalyzer.uzienko.entity.Result;
import ru.javarush.cryptoanalyzer.uzienko.toplevel.Application;
import ru.javarush.cryptoanalyzer.uzienko.views.PicocliView;
import ru.javarush.cryptoanalyzer.uzienko.views.View;

public class Runner {
    public static void main(String[] args) {
        AppController mainController = new MainController();
        View view = new PicocliView();
        Application application = new Application(mainController, view);
        Result result = application.run(args);
        System.out.println(result);
    }
}
