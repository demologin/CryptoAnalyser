package ru.javarush.cryptoanalyser.uzienko;

import ru.javarush.cryptoanalyser.uzienko.controllers.AppController;
import ru.javarush.cryptoanalyser.uzienko.controllers.MainController;
import ru.javarush.cryptoanalyser.uzienko.entity.Result;
import ru.javarush.cryptoanalyser.uzienko.toplevel.Application;
import ru.javarush.cryptoanalyser.uzienko.views.PicocliView;
import ru.javarush.cryptoanalyser.uzienko.views.View;

public class Runner {
    public static void main(String[] args) {
        AppController mainController = new MainController();
        View view = new PicocliView();
        Application application = new Application(mainController, view);
        Result result = application.run(args);
        System.out.println(result);
    }
}
