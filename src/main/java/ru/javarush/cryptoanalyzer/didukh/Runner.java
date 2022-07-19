package ru.javarush.cryptoanalyzer.didukh;

import ru.javarush.cryptoanalyzer.didukh.toplevel.Application;
import ru.javarush.cryptoanalyzer.didukh.controller.MainController;
import ru.javarush.cryptoanalyzer.didukh.entity.Result;
import ru.javarush.cryptoanalyzer.didukh.toplevel.Console;



public class Runner {
    public static void main(String[] args) {
        Console.start();
        args = Console.commands;
        MainController mainController = new MainController();
        Application application = new Application(mainController);
        Result result = application.run(args);
    }
}
