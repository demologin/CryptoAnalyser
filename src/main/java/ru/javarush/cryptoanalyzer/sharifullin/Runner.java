package ru.javarush.cryptoanalyzer.sharifullin;

import ru.javarush.cryptoanalyzer.sharifullin.toplevel.Application;
import ru.javarush.cryptoanalyzer.sharifullin.controller.MainController;
import ru.javarush.cryptoanalyzer.sharifullin.entity.Result;

public class Runner {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        Application application = new Application(mainController);
        Result result=application.run(args);
        System.out.println(result);
    }
}
