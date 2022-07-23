package ru.javarush.cryptoanalyzer.bogdanov;

import ru.javarush.cryptoanalyzer.bogdanov.toplevel.Application;
import ru.javarush.cryptoanalyzer.bogdanov.controller.MainController;
import ru.javarush.cryptoanalyzer.bogdanov.entity.Result;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        MainController maincontroller = new MainController();
        Application application = new Application(maincontroller);
        Result results = application.run(args);
        System.out.println(results.toString());
    }
}