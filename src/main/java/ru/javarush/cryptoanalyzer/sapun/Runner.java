package ru.javarush.cryptoanalyzer.sapun;

import ru.javarush.cryptoanalyzer.sapun.toplevel.Application;
import ru.javarush.cryptoanalyzer.sapun.controller.MainController;
import ru.javarush.cryptoanalyzer.sapun.entity.Result;


public class Runner {
    public static void start(String[] args) {
        MainController mainController = new MainController();
        //encode text.txt encoded.txt 45
        Application application = new Application(mainController);
        Result result = application.run(args);
        System.out.println(result);

    }
}