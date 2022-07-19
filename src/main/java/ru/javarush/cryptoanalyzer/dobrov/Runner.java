package ru.javarush.cryptoanalyzer.dobrov;

import ru.javarush.cryptoanalyzer.dobrov.toplevel.Application;
import ru.javarush.cryptoanalyzer.dobrov.controller.MainController;
import ru.javarush.cryptoanalyzer.dobrov.entity.Result;
import ru.javarush.cryptoanalyzer.dobrov.view.ConsoleRun;

public class Runner {
    public static void main(String[] args) {
        ConsoleRun runner = new ConsoleRun();
        MainController mainController = new MainController();
        //encode text.txt encoded.txt 45
        Application application = new Application(runner, mainController);
        Result result = application.run();
        System.out.println(result);

    }
}
