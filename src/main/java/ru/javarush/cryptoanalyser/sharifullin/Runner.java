package ru.javarush.cryptoanalyser.sharifullin;

import ru.javarush.cryptoanalyser.sharifullin.toplevel.Application;
import ru.javarush.cryptoanalyser.sharifullin.controller.MainController;
import ru.javarush.cryptoanalyser.sharifullin.entity.Result;

public class Runner {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        Application application = new Application(mainController);
        Result result=application.run(args);
        System.out.println(result);
    }
}
