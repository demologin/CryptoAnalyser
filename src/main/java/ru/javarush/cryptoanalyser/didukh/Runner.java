package ru.javarush.cryptoanalyser.didukh;

import ru.javarush.cryptoanalyser.didukh.toplevel.Application;
import ru.javarush.cryptoanalyser.didukh.controller.MainController;
import ru.javarush.cryptoanalyser.didukh.entity.Result;
import ru.javarush.cryptoanalyser.didukh.toplevel.Console;



public class Runner {
    public static void main(String[] args) {
        Console.start();
        args = Console.commands;
        MainController mainController = new MainController();
        Application application = new Application(mainController);
        Result result = application.run(args);
    }
}
